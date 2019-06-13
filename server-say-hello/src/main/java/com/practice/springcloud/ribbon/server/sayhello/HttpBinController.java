package com.practice.springcloud.ribbon.server.sayhello;

import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Luo Bao Ding
 * @since 2019/1/29
 */
@RestController
public class HttpBinController {

    private final RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/status/{code}")
    public Object statusCode(@PathVariable("code") Integer code, HttpServletRequest request) {
        String method = request.getMethod();
        return restTemplate.exchange("http://httpbin.org/status/" + code,
                HttpMethod.valueOf(method), null, Object.class);
    }
}
