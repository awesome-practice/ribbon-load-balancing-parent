package com.practice.springcloud.ribbon.client.user;

import com.netflix.loadbalancer.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by LuoBaoding on 2018/5/7
 */
@Configuration
public class SayHelloConfiguration {


    @Bean
    public IPing ribbonPing() {
        return new PingUrl();
    }

    @Bean
    public IRule ribbonRule() {
//        return new AvailabilityFilteringRule();
        return new RoundRobinRule();
    }

}
