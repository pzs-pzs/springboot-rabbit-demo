package com.example.demo.rabbitconfig;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExchangeRabbitConfig {
    public static final String QUEUE_NAME_A = "spring-boot-rabbit-topic-a";
    public static final String QUEUE_NAME_B = "spring-boot-rabbit-topic-b";

    @Bean
    public Queue queueA(){
        return new Queue(QUEUE_NAME_A);
    }
    @Bean
    public Queue queueB() {
        return new Queue(QUEUE_NAME_B);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("spring-boot-topic-exchange");
    }

    /**
     *  将exchange 和 queue 通过 routing_key 绑定起来
     *  routing_key 通过.区分单词 例如 ： A.B 是A和B两个单词
     *  *表示可匹配任意一个单词 例如: A.* 可与 A.B 匹配
     *  #表示0个或者多个单词 例如 A.# 可与 A.B.C、A.B、A匹配
     * @param queueA
     * @param exchange
     * @return
     */
    @Bean
    Binding bindingExchangeMessage(Queue queueA, TopicExchange exchange) {
        return BindingBuilder.bind(queueA).to(exchange).with("topic.message");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queueB, TopicExchange exchange) {
        return BindingBuilder.bind(queueB).to(exchange).with("topic.#");
    }

}
