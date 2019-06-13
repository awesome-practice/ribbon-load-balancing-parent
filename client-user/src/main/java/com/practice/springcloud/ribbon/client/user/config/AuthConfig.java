package com.practice.springcloud.ribbon.client.user.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Luo Bao Ding
 * @since 2018/5/29
 */
@ConfigurationProperties(prefix = "my")
@Component
public class AuthConfig {
    private List<String> servers = new ArrayList<>();

    public List<String> getServers() {
        return servers;
    }

    public void setServers(List<String> servers) {
        this.servers = servers;
    }

}
