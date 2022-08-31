package com.auction.live.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.auction.live.models.User;
import com.auction.live.repository.UserRepository;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/login")
    public JWTResponse login(@RequestBody JWTRequest request) throws Exception {
        try {
            authenticationManager
                    .authenticate(
                            new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (BadCredentialsException err) {
            throw new Exception("Invalid Username or Password", err);
        }
        final UserDetails userDetails = userAuthService.loadUserByUsername(request.getUsername());
        final String token = jwtUtils.generateToken(userDetails);
        return new JWTResponse(token);
    }

    @PostMapping("/register")
    public JWTResponse register(@RequestBody JWTRequest request) throws Exception {
        if (userRepository.existsByUsername(request.getUsername())) {
            throw new Exception("User already exists");
        } else if (userRepository.existsByEmail(request.getEmail())) {
            throw new Exception("Email is already linked to an account");
        }
        userRepository
                .save(new User().setUsername(request.getUsername())
                        .setPassword(passwordEncoder.encode(request.getPassword())).setEmail(request.getEmail()));
        return login(request);
    }

}
