package com.server;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class SchedulingLogic {
    @Scheduled(cron = "3/1 * * * * ? ")
    public void testScheduling() {
        System.out.println("111111");
    }
}
