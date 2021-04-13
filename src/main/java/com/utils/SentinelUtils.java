package com.utils;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SentinelUtils {
    public static final String key1 = "test";


    public static String addFrequencyBlockHandler(String name, BlockException ex) throws BlockException {
        return "bloack";
    }

    public static String addFrequencyFallbackHandler(String name, Throwable e) throws Throwable {
        return "fallBack";
    }
}
