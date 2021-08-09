package com.shen.rabbit.prodecer;

import com.shen.rabbit.config.RabbitMqConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class Prodecer {

    private final Logger _logger = LoggerFactory.getLogger(this.getClass()) ;
    @Autowired
    private AmqpTemplate rabbitMqTemplate ;

    public void send(){
        String context = "hello" + new Date() ;
        _logger.info("正在向队列发送消息：{}",context);
        this.rabbitMqTemplate.convertAndSend(RabbitMqConfig.queueName,context);
    }
}