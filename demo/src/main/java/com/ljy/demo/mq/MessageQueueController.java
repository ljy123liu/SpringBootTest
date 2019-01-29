package com.ljy.demo.mq;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageQueueController {
    @RequestMapping("/mq")
    public String index() {
        return "learn message queue";
    }
}
