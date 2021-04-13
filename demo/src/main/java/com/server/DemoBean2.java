package com.server;

import org.springframework.stereotype.Component;

@Component
public class DemoBean2 extends BaseDemoBean{
    @Override
    public String getMessage() {
        return "demo2";
    }
}
