package com.example.mygithub.client;

import com.example.mygithub.model.User;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GitHubClient {

    @GET("/users/{userName}")
    Call<User> getUser(@Path("userName") String userName);

}
