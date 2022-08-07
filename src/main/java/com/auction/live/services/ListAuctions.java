package com.auction.live.services;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.auction.live.models.Auction;

@Service
public class ListAuctions {

    public ArrayList<Auction> getUpcomingAuctions() {
        return new ArrayList<Auction>();
    }

    public ArrayList<Auction> hostedAuctions() {
        return new ArrayList<Auction>();
    }

}
