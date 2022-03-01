package com.example.mygithub.service;

import com.example.mygithub.client.GitHubClient;
import com.example.mygithub.exception.UserNotFoundException;
import com.example.mygithub.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import retrofit2.Call;
import retrofit2.Response;

import java.io.IOException;

@Service
public class UserService {

    private final RestTemplate restTemplate;
    private final GitHubClient gitHubClient;
    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(RestTemplate restTemplate, GitHubClient gitHubClient){
        this.restTemplate = restTemplate;
        this.gitHubClient = gitHubClient;
    }

    public User getUsername(String userName){
        return restTemplate.getForObject("https://api.github.com/users/" + userName, User.class);
    }

    public User getUsernameRetrofit(String userName) throws IOException {
        try {
            Call<User> callSync = gitHubClient.getUser(userName);
            Response<User> response = callSync.execute();

            if(response.isSuccessful()){
                User user = response.body();
                return user;
            }

            throw new UserNotFoundException();
        } catch (RuntimeException ex){
            logger.info(ex.getMessage());
            throw ex;
        }
    }
}
