package com.ljy.demo.mq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 1、为什么使用消息队列
// 解耦、异步、削峰
// （解耦）各个系统模块直接不用相互依赖。（异步）一个请求写入多个系统，发送消息到队列，接口返回，异步处理多个系统写入。（削峰）请求积压在MQ，按顺序处理积压数据

// 2、缺点
// 系统可用性降低、复杂度提高、数据一致性问题（异步）

// 3、Kafka（大数据领域）、ActiveMQ（过时）、RabbitMQ（erlang语言，中小型公司）、RocketMQ（阿里，中大型公司）

@RestController
public class MessageQueueController {

    public final static String QUEUE_NAME="rabbitMQ.test";

    @RequestMapping("/mq")
    public String index() {


        return "learn message queue";
    }
}
