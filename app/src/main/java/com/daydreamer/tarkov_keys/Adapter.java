package com.daydreamer.tarkov_keys;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public  class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<Item> ItemList;


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        ViewHolder evh = new ViewHolder(v);
        return evh;
    }
    public Adapter(ArrayList<Item> ItemList) {
        this.ItemList = ItemList;
    }



    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Item currentItem = ItemList.get(position);



        holder.item.setImageResource(currentItem.getItem());


        holder.name.setText(String.valueOf(currentItem.getName()));


holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

       Intent intent = new Intent(view.getContext(), ItemActivity.class);
        Bundle bundle=new Bundle();
        bundle.putSerializable("item",  ItemList.get(position));
        intent.putExtras(bundle);

       view.getContext().startActivity(intent);
    }
});


    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView item;

        public TextView name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.itemImage);


            name =itemView.findViewById(R.id.name);


        }
    }
}
