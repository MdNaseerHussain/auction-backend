package com.auction.live.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auction.live.models.User;
import com.auction.live.services.UserData;

@RestController
@CrossOrigin
public class FetchUser {

    @Autowired
    UserData userData;

    @GetMapping("/user")
    public User getUserData(OAuth2AuthenticationToken auth2AuthenticationToken) {
        return userData.getUser(auth2AuthenticationToken);
    }

}
