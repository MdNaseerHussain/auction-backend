package com.auction.live.controllers;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedular {
    int i=0;
    // 0 */5 * ? * * every 5 minutes
    // 0 55 11 25 8 ? date = 25-08 : 11:55
    @Scheduled(cron="0 55 11 25 8 ?")
    public void execute(){
        System.out.printf("function executed\n");
    }
}
