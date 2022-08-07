package com.auction.live.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auction.live.models.Auction;
import com.auction.live.services.ListAuctions;

@RestController
@CrossOrigin
public class HomePage {

    @Autowired
    private ListAuctions listAuctionsService;

    @GetMapping("/home")
    public Map<String, Object> home() {
        ArrayList<Auction> upcomingAuctions = listAuctionsService.getUpcomingAuctions();
        ArrayList<Auction> hostedAuctions = listAuctionsService.hostedAuctions();
        Map<String, Object> response = new HashMap<String, Object>();
        response.put("upcomingAuctions", upcomingAuctions);
        response.put("hostedAuctions", hostedAuctions);
        return response;
    }

    @GetMapping("/")
    public String landing() {
        return "Default Page";
    }

}
