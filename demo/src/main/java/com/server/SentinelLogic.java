package com.server;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.utils.SentinelUtils;
import org.springframework.stereotype.Service;

@Service
public class SentinelLogic {
    @SentinelResource(value = SentinelUtils.key1,
            blockHandler = "addFrequencyBlockHandler", blockHandlerClass = {SentinelUtils.class},
            fallback = "addFrequencyFallbackHandler", fallbackClass = {SentinelUtils.class})
    public String testSentinel(String name) {
        throw new RuntimeException("error");
       // return name;
    }
}
