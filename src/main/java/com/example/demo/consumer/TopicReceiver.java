package com.example.demo.consumer;


import com.example.demo.rabbitconfig.ExchangeRabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

// 必须加上@Component 否则消费不了
@Slf4j
@Component
public class TopicReceiver {
    @RabbitListener(queues = ExchangeRabbitConfig.QUEUE_NAME_A)
    @RabbitHandler
    public void process(String message) {
        log.info("Topic Receiver1  : {}", message);
    }

    @RabbitListener(queues = ExchangeRabbitConfig.QUEUE_NAME_B)
    @RabbitHandler
    public void process1(String message) {
        log.info("Topic Receiver2  : {}", message);
    }

}
