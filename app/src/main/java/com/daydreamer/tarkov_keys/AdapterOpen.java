package com.daydreamer.tarkov_keys;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterOpen extends RecyclerView.Adapter<AdapterOpen.ViewHolder> {
    private ArrayList<ItemOpen> ItemList;


    @NonNull
    @Override
    public AdapterOpen.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_open_img, parent, false);
        AdapterOpen.ViewHolder evh = new AdapterOpen.ViewHolder(v);
        return evh;
    }
    public AdapterOpen(ArrayList<ItemOpen> ItemList) {
        this.ItemList = ItemList;
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterOpen.ViewHolder holder, int position) {
        final ItemOpen currentItem = ItemList.get(position);

        holder.open.setImageDrawable(currentItem.getOpen());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView image = new ImageView(view.getContext());
                image.setImageDrawable(currentItem.open);



                ViewDialog alert = new ViewDialog();
                alert.showDialog((Activity) view.getContext(), currentItem.open);

            }
        });
    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView open ;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            open = itemView.findViewById(R.id.openImg);





        }
    }
}
