package com.auction.live.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class Hello {

    @GetMapping("/")
    public static String sayHi() {
        return "Hello";
    }

}
