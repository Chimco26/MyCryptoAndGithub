package com.example.mycryptoandgithub.Views.Github;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mycryptoandgithub.Models.Github.GithubUser;
import com.example.mycryptoandgithub.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Chimco26 - RavTech on 10/07/2021.
 */
public class GithubUserViewHolder extends RecyclerView.ViewHolder {

    public interface SetEditText{
        public void onClickInUser(String userName);
    }

    ImageView imageView;
    TextView textTitle;
    TextView textWebsite;
    Picasso picasso;
    EditText editText;
    GithubUser githubUser;
    SetEditText setEditText;

    public GithubUserViewHolder(View itemView, SetEditText setEditText) {
        super(itemView);
        this.setEditText = setEditText;
        imageView = itemView.findViewById(R.id.fragment_main_item_image);
        textTitle = itemView.findViewById(R.id.fragment_main_item_title);
        textWebsite = itemView.findViewById(R.id.fragment_main_item_website);
        picasso = Picasso.with(itemView.getContext());
        editText = itemView.findViewById(R.id.my_edit_text);
        itemView.setOnClickListener(v -> setEditText.onClickInUser(githubUser.getLogin()));
    }

    public void updateWithGithubUser(GithubUser githubUser){
        this.githubUser = githubUser;
        textTitle.setText(githubUser.getLogin());
        textWebsite.setText(githubUser.getHtmlUrl());
        picasso.load(githubUser.getAvatarUrl()).into(imageView);
    }
}
