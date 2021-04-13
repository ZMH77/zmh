package com.confg;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.utils.RuleFactory;
import com.utils.SentinelUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SentinelAspectConfiguration {
    @Bean
    public SentinelResourceAspect sentinelResourceAspect() {
        return new SentinelResourceAspect();
    }

    @PostConstruct
    public void init() {
        RuleFactory.initDegradeRules(
                new String[]{SentinelUtils.key1});

        FlowRule rule = RuleFactory.createFLowQPSRule(SentinelUtils.key1, 100);
        List<FlowRule> rules = new ArrayList<>();
        rules.add(rule);
        RuleFactory.initRules(rules);
    }
}
