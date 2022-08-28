package com.auction.live.controllers;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AuctionPage {

    @GetMapping("/auction")
    public String auction(OAuth2AuthenticationToken auth2AuthenticationToken) {
        return "Auction Page";
    }

}
