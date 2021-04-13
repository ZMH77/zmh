package com.utils;

import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;

import java.util.ArrayList;
import java.util.List;

import static com.alibaba.csp.sentinel.slots.block.RuleConstant.*;

public class RuleFactory {
    public static void initDegradeRules(String[] keys) {
        List<DegradeRule> rules = new ArrayList<DegradeRule>();
        for (String key : keys) {
            RuleConfig rtConfig = new RuleConfig(key, DEGRADE_GRADE_RT);
            DegradeRule rtDegradeRule = createDegradeRule(rtConfig);
            RuleConfig errorRatioConfig = new RuleConfig(key, DEGRADE_GRADE_EXCEPTION_RATIO);
            DegradeRule errorRatioDegradeRule = createDegradeRule(errorRatioConfig);
            RuleConfig errorCountConfig = new RuleConfig(key, DEGRADE_GRADE_EXCEPTION_COUNT);
            DegradeRule errorCountDegradeRule = createDegradeRule(errorCountConfig);
            rules.add(rtDegradeRule);
            rules.add(errorRatioDegradeRule);
            rules.add(errorCountDegradeRule);
        }
        DegradeRuleManager.loadRules(rules);
    }

    private static DegradeRule createDegradeRule(RuleConfig config) {
        DegradeRule rule = new DegradeRule();
        rule.setResource(config.getResource());
        rule.setGrade(config.getGrade());
        rule.setCount(config.getCount());
        rule.setTimeWindow(config.getTimeWindow());
        rule.setSlowRatioThreshold(config.getSlowRatioThreshold());
        rule.setMinRequestAmount(config.getMinRequestAmount());
        return rule;
    }


    public static void initRules(List<FlowRule> rules) {
        FlowRuleManager.loadRules(rules);
    }

    /**
     * 一个资源创建对应一个规则
     * @param resourceName
     * @param qpsLimit
     * @return
     */
    public static FlowRule createFLowQPSRule(String resourceName, int qpsLimit) {
        FlowRule rule = new FlowRule();
        rule.setResource(resourceName);
        rule.setGrade(FLOW_GRADE_QPS);
        rule.setCount(qpsLimit);
        rule.setLimitApp("default");
        return rule;
    }
}
