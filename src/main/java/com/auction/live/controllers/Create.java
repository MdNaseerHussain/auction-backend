package com.auction.live.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Create {

    @GetMapping("/create")
    public static String createAuction() {
        return "Create Auction Page";
    }

}
