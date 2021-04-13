package com.utils;

import static com.alibaba.csp.sentinel.slots.block.RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT;
import static com.alibaba.csp.sentinel.slots.block.RuleConstant.DEGRADE_GRADE_EXCEPTION_RATIO;
import static com.alibaba.csp.sentinel.slots.block.RuleConstant.DEGRADE_GRADE_RT;

public class  RuleConfig {
    // 默认熔断恢复时间10s
    private static final int DEFAULT_WINDOW_TIME = 10;
    // 默认触发熔断最少请求数
    private static final int DEFAULT_MIN_REQUEST_AMOUNT = 2;
    // RT规则下触发熔断的慢查询比例
    private static final double DEFAULT_SLOW_RATIO_THRESHOLD = 0.8d;

    // ratio规则下 默认触发熔断  1s内错误比例
    private static final double ERROR_RATIO = 1.0d;
    // count规则下 默认触发熔断  60s内错误数量
    private static final double ERROR_COUNT = 5d;
    // RT规则下 默认触发熔断  慢请求时间 3000ms > 3000ms为慢请求
    private static final double SLOW_TIME = 3000d;

    public RuleConfig (String resource, int grade) {
        this.resource = resource;
        this.grade = grade;
    }

    /**
     * Resource name.
     */
    private String resource;

    /**
     * RT threshold or exception ratio threshold count.
     */
    private double count;

    /**
     * Degrade recover timeout (in seconds) when degradation occurs.
     */
    private int timeWindow = DEFAULT_WINDOW_TIME;

    /**
     * Degrade strategy (0: average RT, 1: exception ratio, 2: exception count).
     */
    private int grade;

    /**
     * The threshold of slow request ratio in RT mode.
     */
    private double slowRatioThreshold = DEFAULT_SLOW_RATIO_THRESHOLD;

    /**
     * Minimum number of requests (in an active statistic time span) that can trigger circuit breaking.
     *
     * @since 1.7.0
     */
    private int minRequestAmount = DEFAULT_MIN_REQUEST_AMOUNT;

    public double getCount() {
        if (grade == DEGRADE_GRADE_RT) {
            return SLOW_TIME;
        } else if (grade == DEGRADE_GRADE_EXCEPTION_RATIO) {
            return ERROR_RATIO;
        } else if (grade == DEGRADE_GRADE_EXCEPTION_COUNT) {
            return ERROR_COUNT;
        } else {
            throw new IllegalArgumentException("grade is illegal");
        }
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public void setCount(double count) {
        this.count = count;
    }

    public int getTimeWindow() {
        return timeWindow;
    }

    public void setTimeWindow(int timeWindow) {
        this.timeWindow = timeWindow;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getMinRequestAmount() {
        return minRequestAmount;
    }

    public void setMinRequestAmount(int minRequestAmount) {
        this.minRequestAmount = minRequestAmount;
    }

    public double getSlowRatioThreshold() {
        return slowRatioThreshold;
    }

    public void setSlowRatioThreshold(double slowRatioThreshold) {
        this.slowRatioThreshold = slowRatioThreshold;
    }
}
