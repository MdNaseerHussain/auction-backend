package com.auction.live.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auction.live.models.Auction;
import com.auction.live.models.User;
import com.auction.live.services.CreateAuction;
import com.auction.live.services.UserData;

@RestController
@CrossOrigin
public class CreatePage {

    @Autowired
    CreateAuction createAuctionService;
    @Autowired
    UserData userData;

    @PostMapping("/create")
    public Auction createAuction(@RequestBody Auction auction, OAuth2AuthenticationToken auth2AuthenticationToken) {
        User user = userData.getUser(auth2AuthenticationToken);
        if (createAuctionService.validateAuction(auction)) {
            return createAuctionService.create(auction, user);
        } else {
            throw new Error("Invalid Auction details");
        }
    }

}
