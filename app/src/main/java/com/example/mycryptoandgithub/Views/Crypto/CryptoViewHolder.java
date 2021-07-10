package com.example.mycryptoandgithub.Views.Crypto;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mycryptoandgithub.Models.Crypto.CryptoCurrency;
import com.example.mycryptoandgithub.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Chimco26 - RavTech on 11/07/2021.
 */
public class CryptoViewHolder extends RecyclerView.ViewHolder {

    TextView textSymbol;
    TextView usdPrice;
    TextView eurPrice;
    TextView ilsPrice;
    ImageView image;
    Picasso picasso;

    public CryptoViewHolder(View itemView) {
        super(itemView);

        textSymbol = itemView.findViewById(R.id.item_symbol);
        usdPrice = itemView.findViewById(R.id.usd_price);
        eurPrice = itemView.findViewById(R.id.eur_price);
        ilsPrice = itemView.findViewById(R.id.ils_price);
        image = itemView.findViewById(R.id.item_image);
        picasso = Picasso.with(itemView.getContext());
    }

    public void updateItemWithCrypto(CryptoCurrency cryptoCurrency){
        textSymbol.setText(cryptoCurrency.getId());
        usdPrice.setText(cryptoCurrency.getMarketData().getCurrentPrice().getUsd() + " $");
        eurPrice.setText(cryptoCurrency.getMarketData().getCurrentPrice().getEur() + " €");
        ilsPrice.setText(cryptoCurrency.getMarketData().getCurrentPrice().getIls() + " NIS");
        picasso.load(cryptoCurrency.getImage().getSmall()).into(image);
    }
}
