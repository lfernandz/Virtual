package com.seresco.milena.business.service.domain.message;

import com.seresco.milena.commons.service.domain.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQMessageProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.queues.notification}")
    private String routingKey;

    public void send(Notification notification) {
        rabbitTemplate.convertAndSend(routingKey, notification);
    }

}
