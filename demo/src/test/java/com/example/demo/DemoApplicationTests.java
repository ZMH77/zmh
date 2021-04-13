package com.example.demo;

import com.server.SchedulingLogic;
import com.server.SentinelLogic;
import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Ignore
class DemoApplicationTests {
@Autowired
private SchedulingLogic schedulingLogic;
    @Test
    void contextLoads() {
        schedulingLogic.testScheduling();
    }
    @Autowired
    private SentinelLogic sentinelLogic;
    @Test
    public void testSentinel() throws InterruptedException {
        int i =0;
        while (i < 100) {
            System.out.println(sentinelLogic.testSentinel("ok"));
            Thread.sleep(10);
            i++;
        }
    }
}
