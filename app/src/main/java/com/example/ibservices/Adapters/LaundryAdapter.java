package com.example.ibservices.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ibservices.Data.LaundryModel;
import com.example.ibservices.R;


import java.util.List;

public class LaundryAdapter extends RecyclerView.Adapter<LaundryAdapter.LaundryViewHolder> {

    private List<LaundryModel> mList;

    public void setmList(List<LaundryModel> mList) {
        this.mList = mList;
    }

    @NonNull
    @Override
    public LaundryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_laundry, parent, false);
        return new LaundryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LaundryViewHolder holder, int position) {

        holder.tv_cloth.setText(mList.get(position).getName());
        String mprice = String.valueOf(mList.get(position).getPrice());
        holder.tv_price.setText(mprice);
        String imageUrl = mList.get(position).getImages();

        Glide.with(holder.itemView.getContext())
                .load(imageUrl)
                .centerCrop()
                .into(holder.img_cloth);

    }

    @Override
    public int getItemCount() {
        if (mList == null) {
            return 0;
        } else {
            return mList.size();
        }
    }

    public class LaundryViewHolder extends RecyclerView.ViewHolder {
        TextView tv_price, tv_cloth, noOfCloths;
        ImageView img_cloth;
        ImageButton btn_add, btn_remove;

        public LaundryViewHolder(@NonNull View itemView) {
            super(itemView);

            tv_cloth = itemView.findViewById(R.id.cloth_type);
            tv_price = itemView.findViewById(R.id.cloth_price);
            img_cloth = itemView.findViewById(R.id.img_cloth);
            btn_add = itemView.findViewById(R.id.cloth_add);
            btn_remove = itemView.findViewById(R.id.cloth_remove);
            noOfCloths = itemView.findViewById(R.id.No_of_cloth);




        }

    }

}