package com.example.mycryptoandgithub.Views.Github;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mycryptoandgithub.Models.Github.GithubUser;
import com.example.mycryptoandgithub.R;

import java.util.List;

/**
 * Created by Chimco26 - RavTech on 10/07/2021.
 */
public class GithubUserAdapter extends RecyclerView.Adapter<GithubUserViewHolder> {

    List<GithubUser> githubUserList;
    GithubUserViewHolder.SetEditText setEditText;

    public GithubUserAdapter(List<GithubUser> githubUserList, GithubUserViewHolder.SetEditText setEditText) {
        this.githubUserList = githubUserList;
        this.setEditText = setEditText;
    }

    @Override
    public GithubUserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_item_github_user, parent, false);

        return new GithubUserViewHolder(view, setEditText);
    }

    @Override
    public void onBindViewHolder(GithubUserViewHolder holder, int position) {
        holder.updateWithGithubUser(githubUserList.get(position));
    }

    @Override
    public int getItemCount() {
        return this.githubUserList.size();
    }
}
