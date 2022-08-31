package com.auction.live.models;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Document
public class User {

    @Id
    private BigInteger id;
    private String email, username;
    @JsonIgnore
    private String password;
    private List<Auction> hostedAuctions;

    public BigInteger getId() {
        return id;
    }

    public User setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public List<Auction> getHostedAuctions() {
        return hostedAuctions;
    }

    public User setHostedAuctions(List<Auction> hostedAuctions) {
        this.hostedAuctions = hostedAuctions;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

}
