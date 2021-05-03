package com.daydreamer.tarkov_keys;

public class Map {

    public Map(int mapImage, String title) {
        MapImage = mapImage;
        this.title = title;
    }

    public int MapImage;

    public int getMapImage() {
        return MapImage;
    }

    public String getTitle() {
        return title;
    }

    public String title;
}
