package com.daydreamer.tarkov_keys;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterSpawn extends RecyclerView.Adapter<AdapterSpawn.ViewHolder> {
    private ArrayList<ItemSpawn> ItemList;


    @NonNull
    @Override
    public AdapterSpawn.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_spawn_img, parent, false);
        AdapterSpawn.ViewHolder evh = new AdapterSpawn.ViewHolder(v);
        return evh;
    }
    public AdapterSpawn(ArrayList<ItemSpawn> ItemList) {
        this.ItemList = ItemList;
    }
    @Override
    public void onBindViewHolder(@NonNull AdapterSpawn.ViewHolder holder, int position) {
      final  ItemSpawn currentItem = ItemList.get(position);




holder.spawn.setImageDrawable(currentItem.getSpawn());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView image = new ImageView(view.getContext());
                image.setImageDrawable(currentItem.spawn);



                ViewDialog alert = new ViewDialog();
                alert.showDialog((Activity) view.getContext(), currentItem.spawn);

            }
        });

    }

    @Override
    public int getItemCount() {
        return ItemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView spawn;




        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            spawn = itemView.findViewById(R.id.spawnImg);





        }
    }
}
