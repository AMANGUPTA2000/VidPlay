package com.example.vidplay;

import com.google.gson.annotations.SerializedName;

public class List_Data {
    @SerializedName("id")
    private int id;

    @SerializedName("imageurl")
    private String imageurl;

    @SerializedName("name")
    private String name;

    public List_Data(int id, String imageurl, String name) {
        this.id = id;
        this.imageurl = imageurl;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public String getName() {
        return name;
    }
}
