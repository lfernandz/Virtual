package com.seresco.notifications.consumer.service.email;

import com.seresco.milena.commons.service.domain.model.Notification;

public interface EmailService {

    void sendEmail(Notification notification);

}
