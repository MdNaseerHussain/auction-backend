package com.auction.live.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auction.live.models.Auction;
import com.auction.live.services.CreateAuction;

@RestController
@CrossOrigin
public class CreatePage {

    @Autowired
    CreateAuction createAuctionService;

    @PostMapping("/create")
    public Auction createAuction(@RequestBody Auction auction) {
        if (createAuctionService.validateAuction(auction)) {
            return createAuctionService.create(auction);
        } else {
            throw new Error("Invalid Auction details");
        }

    }

}
