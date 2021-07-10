package com.example.mycryptoandgithub.Controllers;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mycryptoandgithub.Models.Crypto.CryptoCurrency;
import com.example.mycryptoandgithub.R;
import com.example.mycryptoandgithub.Utils.Crypto.CurrencyCalls;
import com.example.mycryptoandgithub.Views.Crypto.CryptoAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CryptoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CryptoFragment extends Fragment implements CurrencyCalls.Callbacks {

    private List<CryptoCurrency> cryptoList;
    private CryptoAdapter adapter;
    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CryptoFragment() {
        // Required empty public constructor
    }

    public static CryptoFragment newInstance(String param1, String param2) {
        CryptoFragment fragment = new CryptoFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_crypto, container, false);
        recyclerView = v.findViewById(R.id.my_recycler_view);
        swipeRefreshLayout = v.findViewById(R.id.my_swip_container);
        swipeRefreshLayout.setOnRefreshListener(() -> httpRequest());
        configureRecyclerView();
        httpRequest();
        return v;
    }

    private void httpRequest() {
        CurrencyCalls.fetchCurrencies(this);
    }

    private void configureRecyclerView() {
        cryptoList = new ArrayList<>();
        adapter = new CryptoAdapter(this.cryptoList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onResponse(List<CryptoCurrency> currencies) {
        System.out.println("SYMBOL :" + currencies.get(0).getImage().getSmall());
        swipeRefreshLayout.setRefreshing(false);
        cryptoList.clear();
        cryptoList.addAll(currencies);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure() {
        Log.e("TAG", "ERREUR MON PETIT POULET!!!!!");
    }
}