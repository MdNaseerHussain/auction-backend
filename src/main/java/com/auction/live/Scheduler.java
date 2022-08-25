package com.auction.live;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    // 0 */5 * ? * * every 5 minutes
    // 0 55 11 25 8 ? date = 25-08 : 11:55:00
    @Scheduled(cron = "0 */1 * ? * *")
    public void execute() {
        System.out.println("Function executed at: " + new Date());
    }
}
