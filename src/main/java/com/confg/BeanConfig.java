package com.confg;

import com.server.BaseDemoBean;
import com.server.DemoBean;
import com.server.DemoBean2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration
public class BeanConfig {
    @Bean(name = "bean1")
    public BaseDemoBean buidBean1(){
        return new DemoBean();
    }

    @Bean
    @Primary
    public BaseDemoBean buidBean2(){
        return new DemoBean2();
    }

    @Bean(name = "incrAsyncPoolTaskExecutor")
    public ThreadPoolTaskExecutor getIncrAsyncThreadPoolTaskExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setMaxPoolSize(20);
        taskExecutor.setQueueCapacity(50);
        taskExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
               System.out.println("reject");
            }

        });
        taskExecutor.initialize();
        return taskExecutor;
    }

}
