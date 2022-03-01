package com.example.mygithub.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record User (
    String login,
    int id,
    String url,
    String avatar
){

}
