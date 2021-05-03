package com.daydreamer.tarkov_keys;

import java.io.Serializable;

public class Item implements Serializable {



    public int item;
    public String name;
    public String spawn;
    public String loot;
    public String getId() {
        return id;
    }

    public String id;

    public int[] getSpawnImg() {
        return spawnImg;
    }

    public int[] getOpenImg() {
        return openImg;
    }

    public  int[] spawnImg;
    public  int[] openImg;

    public Item(String id, String name,String spawn,String loot, int item,int[] spawnImg, int[] openImg) {
        this.id = id;
        this.item = item;
        this.name = name;
        this.spawnImg = spawnImg;
        this.openImg = openImg;
        this.spawn = spawn;
        this.loot = loot;
    }






    public String getSpawn() {
        return spawn;
    }


    public String getLoot() {
        return loot;
    }

    public String getName() {
        return name;
    }

    public int getItem() {
        return item;
    }




}
