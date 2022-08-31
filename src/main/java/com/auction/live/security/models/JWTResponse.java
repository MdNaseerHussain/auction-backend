package com.auction.live.security.models;

public class JWTResponse {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public JWTResponse(String token) {
        this.token = token;
    }

    public JWTResponse() {
        super();
    }

}
