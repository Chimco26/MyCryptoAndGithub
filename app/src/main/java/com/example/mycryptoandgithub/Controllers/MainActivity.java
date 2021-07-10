package com.example.mycryptoandgithub.Controllers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.mycryptoandgithub.R;
import com.example.mycryptoandgithub.Views.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager2 viewPager2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager2 = findViewById(R.id.my_view_pager);
        viewPager2.setAdapter(new ViewPagerAdapter(this));
    }
}