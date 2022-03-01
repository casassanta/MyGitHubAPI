package com.example.mygithub.controller;


import com.example.mygithub.model.User;
import com.example.mygithub.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/api/users/{userName}")
    public User getUsername(@PathVariable String userName) throws IOException {
        return userService.getUsernameRetrofit(userName);
    }

}
