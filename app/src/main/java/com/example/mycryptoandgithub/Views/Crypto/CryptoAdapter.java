package com.example.mycryptoandgithub.Views.Crypto;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mycryptoandgithub.Models.Crypto.CryptoCurrency;
import com.example.mycryptoandgithub.R;

import java.util.List;

/**
 * Created by Chimco26 - RavTech on 11/07/2021.
 */
public class CryptoAdapter extends RecyclerView.Adapter<CryptoViewHolder> {

    private List<CryptoCurrency> cryptoList;

    public CryptoAdapter(List<CryptoCurrency> cryptoList) {
        this.cryptoList = cryptoList;
    }

    @Override
    public CryptoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_item_crypto, parent, false);

        return new CryptoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CryptoViewHolder holder, int position) {
        holder.updateItemWithCrypto(this.cryptoList.get(position));

    }

    @Override
    public int getItemCount() {
        return cryptoList.size();
    }
}
