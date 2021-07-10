package com.example.mycryptoandgithub.Models.Crypto;

import com.example.mycryptoandgithub.Models.Crypto.CurrentPrice;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chimco26 - RavTech on 11/07/2021.
 */
public class MarketData {
    @SerializedName("current_price")
    @Expose
    private CurrentPrice currentPrice;

    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }
}
