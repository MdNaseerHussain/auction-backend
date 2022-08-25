package com.auction.live.repository;

import java.math.BigInteger;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.auction.live.models.Auction;

public interface AuctionsRepository extends MongoRepository<Auction, BigInteger> {

    public Auction findByName(String name);

}
