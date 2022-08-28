package com.auction.live.controllers;

import java.util.Map;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class UserData {

    @GetMapping("/user")
    public Map<String, Object> auction(OAuth2AuthenticationToken auth2AuthenticationToken) {
        return auth2AuthenticationToken.getPrincipal().getAttributes();
    }

}
