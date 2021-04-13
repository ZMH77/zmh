package com.server;

import org.springframework.stereotype.Component;

@Component
public class DemoBean extends BaseDemoBean{
    @Override
    public String getMessage() {
        return "demo1";
    }
}
