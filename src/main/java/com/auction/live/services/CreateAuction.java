package com.auction.live.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auction.live.models.Auction;
import com.auction.live.models.Item;
import com.auction.live.repository.AuctionsRepository;

@Service
public class CreateAuction {

    @Autowired
    private AuctionsRepository auctionsRepository;

    public boolean validateItem(Item item) {
        if (item.getName().isEmpty() || item.getName() == null || item.getBasePrice() <= 0
                || item.getDescription() == null || item.getDescription().isEmpty()) {
            return false;
        }
        return true;
    }

    public boolean validateAuction(Auction auction) {
        if (auction.getName().isEmpty() || auction.getName() == null || auction.getItems().isEmpty()
                || auction.getItems() == null) {
            return false;
        }
        for (Item item : auction.getItems()) {
            if (!validateItem(item)) {
                return false;
            }
        }
        return true;
    }

    public Auction create(Auction auction) {
        auctionsRepository.save(auction);
        return auction;
    }

}
