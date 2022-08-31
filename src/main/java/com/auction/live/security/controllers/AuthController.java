package com.auction.live.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auction.live.security.models.JWTRequest;
import com.auction.live.security.models.JWTResponse;
import com.auction.live.security.services.UserAuthService;
import com.auction.live.security.utils.JWTUtils;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserAuthService userAuthService;

    @Autowired
    private JWTUtils jwtUtils;

    @PostMapping("/login")
    public JWTResponse authenticate(@RequestBody JWTRequest req) throws Exception {
        try {
            authenticationManager
                    .authenticate(new UsernamePasswordAuthenticationToken(req.getUsername(), req.getPassword()));
        } catch (BadCredentialsException err) {
            throw new Exception("Invalid Username or Password", err);
        }
        final UserDetails userDetails = userAuthService.loadUserByUsername(req.getUsername());
        final String token = jwtUtils.generateToken(userDetails);
        return new JWTResponse(token);
    }

}
