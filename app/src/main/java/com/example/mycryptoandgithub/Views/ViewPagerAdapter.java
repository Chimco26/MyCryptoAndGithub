package com.example.mycryptoandgithub.Views;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.mycryptoandgithub.Controllers.CryptoFragment;
import com.example.mycryptoandgithub.Controllers.GithubFragment;

/**
 * Created by Chimco26 - RavTech on 10/07/2021.
 */
public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @Override
    public Fragment createFragment(int position) {
        if (position == 0)
            return new GithubFragment();
        else return new CryptoFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}
