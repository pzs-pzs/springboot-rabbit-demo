package com.example.demo.producer;

import com.example.demo.domain.User;
import com.example.demo.rabbitconfig.RabbitConfig;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender {
    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send() {
        this.amqpTemplate.convertAndSend(RabbitConfig.QUEUE_NAME, buildUser("userA","pawA"));

        //参数表示的含义：exchangeName、routingKey、message
        this.amqpTemplate.convertAndSend("spring-boot-topic-exchange","topic.message","HelloA");

        this.amqpTemplate.convertAndSend("spring-boot-topic-exchange","topic.A.B","HelloB");
    }

    private User buildUser(String name, String pwd) {
        User u = new User();
        u.setName(name);
        u.setPwd(pwd);
        return u;
    }
}
