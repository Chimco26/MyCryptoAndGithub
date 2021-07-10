package com.example.mycryptoandgithub.Utils.Crypto;

import android.util.Log;

import com.example.mycryptoandgithub.Models.Crypto.CryptoCurrency;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Chimco26 - RavTech on 11/07/2021.
 */
public class CurrencyCalls {
    public interface Callbacks{
        void onResponse(List<CryptoCurrency> currencies);
        void onFailure();
    }

    public static void fetchCurrencies(Callbacks callbacks){
        final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<>(callbacks);

        CryptoService cryptoService = CryptoService.retrofit.create(CryptoService.class);

        Call<List<CryptoCurrency>> call = cryptoService.getCurrencies();
        call.enqueue(new Callback<List<CryptoCurrency>>() {
            @Override
            public void onResponse(Call<List<CryptoCurrency>> call, Response<List<CryptoCurrency>> response) {
                if (response.body() == null){
                    Log.e("TAG", "GALERE HABIBI");
                    callbacksWeakReference.get().onFailure();
                }else if (callbacksWeakReference.get() != null){
                    Log.e("TAG", " " + response.body().toString());
                    callbacksWeakReference.get().onResponse(response.body());
                }
            }
            @Override
            public void onFailure(Call<List<CryptoCurrency>> call, Throwable t) {
                Log.e("TAG", "galere grave " + t.getMessage());
                if (callbacksWeakReference.get() != null)
                    callbacksWeakReference.get().onFailure();
            }
        });
    }
}
