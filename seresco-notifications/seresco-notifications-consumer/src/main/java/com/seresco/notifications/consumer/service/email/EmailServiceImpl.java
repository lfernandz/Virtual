package com.seresco.notifications.consumer.service.email;

import com.seresco.milena.commons.service.domain.model.Notification;
import com.seresco.notifications.consumer.service.email.config.JavaMailConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailConfig javaMailConfig;

    @Override
    public void sendEmail(Notification notification) {

        JavaMailSender javaMailSender = javaMailConfig.getJavaMailSender();
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setSubject(notification.getSubject());
        msg.setText(notification.getMessage());

        List<String> emails = notification.getEmails();
        if (null != emails && !emails.isEmpty()) {
            for (String email : emails) {
                msg.setTo(email);
                javaMailSender.send(msg);
            }
        }
        else {
            msg.setTo(notification.getTo());
            javaMailSender.send(msg);
        }

    }
}
