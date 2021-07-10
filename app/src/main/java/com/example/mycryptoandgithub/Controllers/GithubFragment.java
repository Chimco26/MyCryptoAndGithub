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
import android.widget.Button;
import android.widget.EditText;

import com.example.mycryptoandgithub.Models.Github.GithubUser;
import com.example.mycryptoandgithub.R;
import com.example.mycryptoandgithub.Utils.Github.GithubCalls;
import com.example.mycryptoandgithub.Views.Github.GithubUserAdapter;
import com.example.mycryptoandgithub.Views.Github.GithubUserViewHolder;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GithubFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GithubFragment extends Fragment
        implements GithubCalls.Callbacks, View.OnClickListener, GithubUserViewHolder.SetEditText {

    RecyclerView recyclerView;
    SwipeRefreshLayout swipeRefreshLayout;
    private GithubUserAdapter adapter;
    List<GithubUser> githubUserList;
    Button followingButton;
    Button followersButton;
    EditText editText;
    String username;
    int buttonTag;

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public GithubFragment() {
        // Required empty public constructor
    }

    public static GithubFragment newInstance(String param1, String param2) {
        GithubFragment fragment = new GithubFragment();
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
        View v = inflater.inflate(R.layout.fragment_github, container, false);
        recyclerView = v.findViewById(R.id.my_recycler_github);
        followingButton = v.findViewById(R.id.my_following_button);
        followersButton = v.findViewById(R.id.my_follower_button);
        followingButton.setOnClickListener(this);
        followersButton.setOnClickListener(this);
        editText = v.findViewById(R.id.my_edit_text);
        configureRecyclerView();
        swipeRefreshLayout = v.findViewById(R.id.my_swipe_refresh);
        swipeRefreshLayout.setOnRefreshListener(() -> buttonClick());
        return v;
    }

    @Override
    public void onResponse(List<GithubUser> users) {
        swipeRefreshLayout.setRefreshing(false);
        githubUserList.clear();
        githubUserList.addAll(users);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure() {
        editText.setText("");
        editText.setHint("Have not follow!!!");

    }


    private  void configureRecyclerView(){
        githubUserList = new ArrayList<>();
        adapter = new GithubUserAdapter(githubUserList, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onClick(View v) {
        this.username = editText.getText().toString();
        this.buttonTag = Integer.parseInt(v.getTag().toString());
        buttonClick();
    }

    private void buttonClick() {
        Log.e("TAG", "CLICK!!! TAG N :" + buttonTag);
        if(buttonTag == 1)
            GithubCalls.fetchUserFollowing(this, username, "following");
        else GithubCalls.fetchUserFollowing(this, username, "followers");
    }

    @Override
    public void onClickInUser(String userName) {
        editText.setText(userName);
    }
}