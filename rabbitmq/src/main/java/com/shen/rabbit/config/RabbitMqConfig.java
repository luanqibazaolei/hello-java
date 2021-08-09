package com.shen.rabbit.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMqConfig {

    public static final String queueName = "springcloud-server-bus-rabbitmq" ;
    public Queue rabbitMqQueue(){
        return new Queue(queueName);
    }
}