package com.shen.rabbit.consumer;

import com.shen.rabbit.config.RabbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = RabbitMqConfig.queueName)
public class Consumer {
    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;

    @RabbitHandler
    public void consumer(String message){
        _logger.info("从队列获取到的消息:{}",message);
    }
}