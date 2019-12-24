package com.example.springboot.rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * RocketMQConsumer
 *
 * @author ljy
 * @since 2019/11/25 下午9:00
 */
public class RocketMQConsumer {
    public static void start() {
        new Thread() {
            @Override
            public void run() {
                try {
                    // 消费者实例，credit_group之类就是消费者分组
                    // 一般来说积分系统 credis_consumer_group，营销系统marketing_consumer_group
                    DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("credit_group");
                    consumer.setNamesrvAddr("127.0.0.1:9876");
                    // 选择订阅"TopicOrderPaySuccess"的消息。这样会从这个Topic的broker机器上拉取订单消息
                    consumer.subscribe("TopicOrderPaySuccess","*");

                    consumer.registerMessageListener(new MessageListenerConcurrently() {
                        @Override
                        public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                                        ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                            // 在这里对获取到的list消息进行处理
                            // 比如增加积分、发送优惠券
                            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                        }
                    });

                    // 启动消费者实例
                    consumer.start();
                    System.out.printf("Consumer Started.%n");

                    // 不让线程退出，让consumer不停消费数据
                    while (true) {
                        Thread.sleep(1000);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
