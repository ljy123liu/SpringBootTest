package com.example.springboot.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * RocketMQProducer
 *
 * @author ljy
 * @since 2019/11/25 下午8:52
 */
public class RocketMQProducer {
    // RocketMQ的生产者类
    private static DefaultMQProducer producer;

    static {
        // 构建Producer实例对象
        producer = new DefaultMQProducer("order_producer_group");

        // 设置NameServer的地址，可以拉取路由信息，这样才知道每个Topic的数据分散在哪里Broker机器上，然后才可以把消息发送到Broker上
        producer.setNamesrvAddr("127.0.0.1:9876");
        // 启动Producer
        try {
            producer.start();
            // 设置一步发送失败的时候重试次数为0
            producer.setRetryTimesWhenSendAsyncFailed(0);
        } catch (MQClientException e) {
            System.out.println(e.getErrorMessage());
        }
    }

    public static void send(String topic,String message) throws Exception {
        // 构建一条消息对象
        Message msg = new Message(
                topic,
                "",
                message.getBytes(RemotingHelper.DEFAULT_CHARSET));

        // Producer发送消息，同步模式
        SendResult sendResult = producer.send(msg);
        System.out.printf("%s%n",sendResult);

        //Producer发送消息，异步模式
        producer.send(msg, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {

            }

            @Override
            public void onException(Throwable throwable) {

            }
        });

        //Producer发送消息，单向消息
        producer.sendOneway(msg);
    }
}
