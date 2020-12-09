package com.example.ibservices.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ibservices.Data.ServicesListModel;
import com.example.ibservices.R;

import java.util.List;

public class ServicesRecyclerAdapter extends RecyclerView.Adapter<ServicesRecyclerAdapter.ServicesViewholder> implements View.OnClickListener {

    private List<ServicesListModel> mServicesListModels;
    private servicesListItemClicked mServicesListItemClicked;


    public ServicesRecyclerAdapter(servicesListItemClicked servicesListItemClicked) {
        this.mServicesListItemClicked = servicesListItemClicked;
    }



    public void setServicesListModels(List<ServicesListModel> servicesListModelList) {
        this.mServicesListModels = servicesListModelList;
    }


    @NonNull
    @Override
    public ServicesViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_services, parent, false);
        return new  ServicesViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ServicesViewholder holder, int position) {

        holder.serviceText.setText(mServicesListModels.get(position).getName());
        String imageUrl = mServicesListModels.get(position).getImage();

        Glide.with(holder.itemView.getContext())
                .load(imageUrl)
                .centerCrop()
                .into(holder.servicesImage);

    }

    @Override
    public int getItemCount() {
        if (mServicesListModels == null){
            return 0;
        }else {
            return mServicesListModels.size();
        }
    }

    @Override
    public void onClick(View view) {
    }


    public class ServicesViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView servicesImage;
        private TextView serviceText;
        private CardView servicesCardView;

        public ServicesViewholder(@NonNull View itemView) {
            super(itemView);

            servicesImage = itemView.findViewById(R.id.services_image);
            serviceText = itemView.findViewById(R.id.services_text);
            servicesCardView = itemView.findViewById(R.id.cardview_services);

            servicesCardView.setOnClickListener(this);

        }

        @Override
        public void onClick(View view) {
            mServicesListItemClicked.itemClicked(mServicesListModels.get(getAdapterPosition()), getAdapterPosition());
        }
    }

    public interface servicesListItemClicked{
        void itemClicked(ServicesListModel model, int position);

    }

}
