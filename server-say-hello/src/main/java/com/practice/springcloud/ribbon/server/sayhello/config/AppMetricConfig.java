package com.practice.springcloud.ribbon.server.sayhello.config;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.boot.actuate.autoconfigure.metrics.MeterRegistryCustomizer;
import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author Luo Bao Ding
 * @since 2019/1/30
 */
@Configuration
public class AppMetricConfig implements EnvironmentAware {
    private Environment environment;

    @Bean
    public MeterRegistryCustomizer<MeterRegistry> metricCommonTags() {
        String appName = environment.getProperty("spring.application.name");
        return registry -> {
            registry.config().commonTags("appName", appName);
        };
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
