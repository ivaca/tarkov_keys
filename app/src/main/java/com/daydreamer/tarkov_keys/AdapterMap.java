package com.daydreamer.tarkov_keys;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterMap extends RecyclerView.Adapter<AdapterMap.ViewHolder>{
    private ArrayList<Map> ItemList;
    @NonNull
    @Override
    public AdapterMap.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.map_item, parent, false);
        AdapterMap.ViewHolder evh = new AdapterMap.ViewHolder(v);
        return evh;
    }
    public AdapterMap(ArrayList<Map> ItemList) {
        this.ItemList = ItemList;
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterMap.ViewHolder holder, int position) {
        Map currentItem = ItemList.get(position);



        holder.mapImage.setImageResource(currentItem.getMapImage());


        holder.title.setText(String.valueOf(currentItem.getTitle()));
    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mapImage;

        public TextView title;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mapImage = itemView.findViewById(R.id.mapImg);


            title =itemView.findViewById(R.id.titleMap);


        }
    }
}
