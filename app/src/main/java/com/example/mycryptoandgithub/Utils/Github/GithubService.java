package com.example.mycryptoandgithub.Utils.Github;

import com.example.mycryptoandgithub.Models.Github.GithubUser;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Chimco26 - RavTech on 10/07/2021.
 */
public interface GithubService {
    @GET("users/{username}/{follow}")
    Call<List<GithubUser>> getFollowing(@Path("username") String username, @Path("follow") String follow);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
