package com.practice.springcloud.ribbon.server.sayhello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class TechCaseController {

    private static Logger log = LoggerFactory.getLogger(TechCaseController.class);

    @Value("${sleepTimeInSeconds:3}")
    private int sleepTimeInSeconds;

    @Value("${server.port}")
    private int serverPort;

    @RequestMapping(value = "/greeting")
    public String greet() {
        log.info("Access /greeting");

        List<String> greetings = Arrays.asList("Hi there", "Greetings", "Salutations");
        Random rand = new Random();

        int randomNum = rand.nextInt(greetings.size());
        return greetings.get(randomNum);
    }

    @RequestMapping(value = "/")
    public String home() {
        log.info("Access /");
        return "Hi!";
    }

    @RequestMapping(value = "/recommended")
    public String readingList() {
        log.info("Access /sayhello/recommended");
        return "Spring in Action (Manning), Cloud Native Java (O'Reilly), Learning Spring Boot (Packt)";
    }


    @RequestMapping("/sleep/{timeInSeconds}")
    public String sleep(@PathVariable("timeInSeconds") int timeInSeconds) {
        try {
//            log.info("Access /sleep/" + timeInSeconds);
            System.out.println("Access /sleep/" + timeInSeconds + ";" + Instant.now().toString());

            Thread.sleep(timeInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "success accessed /sleep/" + timeInSeconds;

    }

    /**
     * java -jar ./target/server-say-hello-1.0-SNAPSHOT.jar --sleepTimeInSeconds=1 --server.port=8094
     */
    @RequestMapping("/retry")
    public String retry() {
        long currentTimeMillis = System.currentTimeMillis();
        Date date = new Date(currentTimeMillis);
        System.out.println(date + ", serverPort:" + serverPort + ", start sleep :" + sleepTimeInSeconds + " seconds");
        try {
            Thread.sleep(sleepTimeInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return date + ", serverPort:" + serverPort + ", slept: " + sleepTimeInSeconds + ", success";
    }


    @RequestMapping("/err")
    public String error() {
        int x = 1 / 0;
        return "ok";

    }

    @RequestMapping("/exception")
    public String exception() {
        if (true) {
            throw new RuntimeException("manual exception");
        }
        return "ok";

    }

}