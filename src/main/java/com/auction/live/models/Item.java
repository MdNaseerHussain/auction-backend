package com.auction.live.models;

import java.math.BigInteger;

public class Item {

    private BigInteger id;
    private String name, description;
    private int basePrice;
    // TODO: Add image attribute

    public BigInteger getId() {
        return id;
    }

    public Item setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Item setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Item setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getBasePrice() {
        return basePrice;
    }

    public Item setBasePrice(int basePrice) {
        this.basePrice = basePrice;
        return this;
    }

}
