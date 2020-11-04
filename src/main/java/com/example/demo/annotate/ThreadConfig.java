package com.example.demo.annotate;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

/**
 * @description: ThreadConfig
 * @author: leiming5
 * @date: 2020-11-04 14:38
 */
@Configuration
@ComponentScan("com.example.demo.annotate")
@EnableAsync// 在Spring中实现多线程
public class ThreadConfig {

    // 这里是声明一个bean，类似于xml中的<bean>标签。
    // Executor 就是一个线程池
    @Bean
    public Executor getExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setMaxPoolSize(10);
        executor.setQueueCapacity(25);
        executor.initialize();
        return executor;
    }

}
