package com.example.mycryptoandgithub.Models.Crypto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Chimco26 - RavTech on 11/07/2021.
 */
public class CryptoCurrency {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("symbol")
    @Expose
    private String symbol;
    @SerializedName("image")
    @Expose
    private Image image;
    @SerializedName("market_data")
    @Expose
    private MarketData marketData;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public MarketData getMarketData() {
        return marketData;
    }

    public void setMarketData(MarketData marketData) {
        this.marketData = marketData;
    }
}
