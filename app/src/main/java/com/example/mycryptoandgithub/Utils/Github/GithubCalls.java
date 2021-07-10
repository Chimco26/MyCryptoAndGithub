package com.example.mycryptoandgithub.Utils.Github;

import com.example.mycryptoandgithub.Models.Github.GithubUser;

import java.lang.ref.WeakReference;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Chimco26 - RavTech on 10/07/2021.
 */
public class GithubCalls {

        // 1 - Creating a callback
        public interface Callbacks {
            void onResponse(List<GithubUser> users);
            void onFailure();
        }

        // 2 - Public method to start fetching users following by Jake Wharton
        public static void fetchUserFollowing(Callbacks callbacks, String username, String follow){

            // 2.1 - Create a weak reference to callback (avoid memory leaks)
            final WeakReference<Callbacks> callbacksWeakReference = new WeakReference<Callbacks>(callbacks);

            // 2.2 - Get a Retrofit instance and the related endpoints
            GithubService gitHubService = GithubService.retrofit.create(GithubService.class);

            // 2.3 - Create the call on Github API
           Call<List<GithubUser>> call = gitHubService.getFollowing(username, follow);
            // 2.4 - Start the call
            call.enqueue(new Callback<List<GithubUser>>() {
                @Override
                public void onResponse(Call<List<GithubUser>> call, Response<List<GithubUser>> response) {
                    if (response == null){
                        if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
                    }
                    if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onResponse(response.body());
                }

                @Override
                public void onFailure(Call<List<GithubUser>> call, Throwable t) {
                    if (callbacksWeakReference.get() != null) callbacksWeakReference.get().onFailure();
                }
            });
        }
}

