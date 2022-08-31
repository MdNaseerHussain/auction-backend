package com.auction.live.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.auction.live.repository.UserRepository;

import java.util.ArrayList;

@Service
public class UserAuthService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.auction.live.models.User user = userRepository.findByUsername(username);
        User userDetails = new User(username, user.getPassword(), new ArrayList<>());
        return userDetails;
    }
}
