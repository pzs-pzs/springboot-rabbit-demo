package com.example.demo.rabbitconfig;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *  直接发送给queue不需要通过路由exchange
 */
@Configuration
public class RabbitConfig {

    public static final String QUEUE_NAME = "spring-boot-rabbit-mq";

    @Bean
    public Queue queue() {
        return new Queue(QUEUE_NAME);
    }
}
