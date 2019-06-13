package com.practice.springcloud.ribbon.client.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by LuoBaoding on 2018/5/8
 */
@RestController
@RefreshScope
public class ConfigClientController {
    /**
     * pull fresh config value:
     * post: http://localhost:8888/actuator/refresh
     */
    @Value("${text: hi default}")
    private String text;

    @RequestMapping("text")
    public String getText() {
        return this.text;
    }
}
