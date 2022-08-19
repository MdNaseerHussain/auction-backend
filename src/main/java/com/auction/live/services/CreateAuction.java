package com.auction.live.services;

import org.springframework.stereotype.Service;

import com.auction.live.models.Auction;
import com.auction.live.models.Item;

@Service
public class CreateAuction {

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
        Auction newAuction = new Auction();
        newAuction.setId(auction.getId()).setName(auction.getName()).setItems(auction.getItems())
                .setDescription(auction.getDescription());
        return newAuction;
    }

}
