package com.example.demo.consumer;

import com.example.demo.domain.User;
import com.example.demo.rabbitconfig.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_NAME)
public class Receiver {

    @RabbitHandler
    public void process(User user) {
        log.info("this is a demo , the user is {}", user);
    }
}
