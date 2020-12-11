package com.example.ibservices.ViewModels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;

import com.example.ibservices.Data.Checkout;
import com.example.ibservices.Data.LaundryModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CartViewModel  {

    /**
     * Maintains a list of your selected items and their quantities.
     * You may want to find a way to synchronize this. Otherwise, you could have problems when two items are selected at the same time.
     */
    MutableLiveData<List<LaundryModel>> cartItems = new MutableLiveData<>();

    /**
     * This gives you total price of all selected items. You can observe this in your fragment to update your views
     */
    LiveData<Long> totalPrice = Transformations.map(cartItems, (items) -> {
        long total = 0L;
        for (LaundryModel item : items) {
            total += item.totalPrice();
        }
        return total;
    });

    /**
     * Check if cart is empty. Well,
     * @return boolean empty or not
     */
    boolean isCartEmpty() {
        return cartItems.getValue() == null || cartItems.getValue().isEmpty();
    }

    /**
     * When you want to checkout, you get all the items using this method. You should not call this method if there is nothing in cart, otherwise, exception is thrown
     *
     * @return checkout items
     */
    Checkout checkout() {
        if (cartItems.getValue() == null || cartItems.getValue().isEmpty())
            throw new IllegalStateException("There is nothing in this cart! Please add items first!");
        return new Checkout(cartItems.getValue());
    }

    /**
     * The method runs whenever you click add or subtract button. You get the selected item from the adapter.
     *
     * @param shopItem  shop item from your recyclerview adapter. You may want to also use the same list in this viewModel to update your adapter
     * @param shouldAdd indicates you want to add or remove
     */
    void itemSelected(LaundryModel shopItem, Boolean shouldAdd) {
        // This is a new list that we use to update the selected items.
        ArrayList<LaundryModel> selectedItems = new ArrayList<>();
        // Get a hold of the current items or use empty list if nothing is selected
        List<LaundryModel> currentItems = cartItems.getValue() == null ? Collections.emptyList() : cartItems.getValue();
        // Loop through the current items to find the selected item. If found, increase or decrease the quantity, or remove it if the quantity is now zero.

        boolean itemExist = false;
        for (LaundryModel item : currentItems) {
            if (item.id.equals(shopItem.id)) {
                int newQuantity = shouldAdd ? item.quantitySelected + 1 : item.quantitySelected - 1;
                if (newQuantity > 0) { // Do not add the item if we had one and remove was selected
                    LaundryModel updatedShopItem = new LaundryModel(item.id, item.name, item.getType(), item.images, item.price);
                    updatedShopItem.quantitySelected = newQuantity;
                    selectedItems.add(updatedShopItem);
                }
                // The item already exists in the current list
                itemExist = true;
            } else {
                // It's a new item. So we just add it back if add is clicked
                if (shouldAdd) selectedItems.add(item);
            }
        }

        if (!itemExist && shouldAdd) {
            // Item does not exist. We want to add the new item
            LaundryModel newItem = new LaundryModel(shopItem.id, shopItem.name, shopItem.type, shopItem.images, shopItem.price);
            newItem.quantitySelected = 1;
            selectedItems.add(newItem);
        }

        // Finally update the liveData
        cartItems.setValue(selectedItems);
    }
}
