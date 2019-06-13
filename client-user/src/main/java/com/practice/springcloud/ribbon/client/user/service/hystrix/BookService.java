package com.practice.springcloud.ribbon.client.user.service.hystrix;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@CommonsLog
@Service
public class BookService {

    private final RestTemplate restTemplate;

    public BookService(RestTemplate rest) {
        this.restTemplate = rest;
    }

    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList() {
        log.info("Access /recommended");
        return this.restTemplate.getForObject("http://ribbon-practice-server-say-hello/recommended", String.class);
    }

    public String reliable() {
        return "fall back";
    }

}