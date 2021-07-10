package com.example.mycryptoandgithub.Models.Crypto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chimco26 - RavTech on 11/07/2021.
 */
public class Image {
    @SerializedName("small")
    @Expose
    private String small;

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }
}
