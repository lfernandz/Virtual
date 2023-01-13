package com.seresco.notifications.consumer;

import com.seresco.milena.commons.service.domain.model.Notification;
import com.seresco.notifications.consumer.service.email.EmailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationConsumer {

    @Autowired
    private EmailService emailService;

    @RabbitListener(queues = "user")
    public void sendEmail(Notification notification) throws InterruptedException {
        emailService.sendEmail(notification);
//        LOG.debug("New Email Queue message....: {}",notification);
    }

}
