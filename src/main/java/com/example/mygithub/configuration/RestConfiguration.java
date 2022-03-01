package com.example.mygithub.configuration;

import com.example.mygithub.client.GitHubClient;
import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

@Configuration
public class RestConfiguration {


    @Bean
    public Retrofit retrofit(){
        var httpClient = new OkHttpClient.Builder();
        return new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(JacksonConverterFactory.create())
                .client(httpClient.build())
                .build();
    }

    @Bean
    public GitHubClient gitHubClient(Retrofit retrofit){
        return retrofit.create(GitHubClient.class);
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
