package com.auction.live.models;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;

public class Auction {

    @Id
    private BigInteger id;
    private String name, description;
    private ArrayList<Item> items;
    private List<String> invitees;

    public BigInteger getId() {
        return id;
    }

    public Auction setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Auction setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Auction setDescription(String description) {
        this.description = description;
        return this;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public Auction setItems(ArrayList<Item> items) {
        this.items = items;
        return this;
    }

    public List<String> getInvitees() {
        return invitees;
    }

    public Auction setInvitees(List<String> invitees) {
        this.invitees = invitees;
        return this;
    }

}
