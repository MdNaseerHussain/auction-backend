package com.auction.live.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.stereotype.Service;

import com.auction.live.models.Auction;
import com.auction.live.models.User;
import com.auction.live.repository.UserRepository;

@Service
public class UserData {

    @Autowired
    UserRepository userRepository;

    public User getUser(OAuth2AuthenticationToken auth2AuthenticationToken) {
        String userEmail = auth2AuthenticationToken.getPrincipal().getAttribute("email");
        if (userRepository.existsByEmail(userEmail)) {
            return userRepository.findByEmail(userEmail);
        }
        User user = new User();
        user.setEmail(userEmail).setHostedAuctions(new ArrayList<Auction>())
                .setName(auth2AuthenticationToken.getPrincipal().getAttribute("name"));
        userRepository.save(user);
        return user;
    }

}
