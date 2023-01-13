package com.seresco.milena.business.service.domain.implementation;

import com.seresco.milena.business.service.domain.port.EntitiesGroupPersistencePort;
import com.seresco.milena.business.service.domain.model.EntitiesGroup;
import com.seresco.milena.business.service.domain.service.EntitiesGroupService;
import com.seresco.milena.business.service.domain.message.RabbitMQMessageProducer;
import com.seresco.milena.commons.service.domain.model.Notification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultEntitiesGroupService implements EntitiesGroupService {

    @Autowired
    private EntitiesGroupPersistencePort persistencePort;

    @Autowired
    private RabbitMQMessageProducer messageProducer;

    @Override
    public List<EntitiesGroup> findAll() {
        Notification notification = new Notification();
        notification.setSubject("First Example");
        notification.setMessage("Este es el primer correo de prueba");
        notification.setTo("leandro.fernandez@externos.seresco.es");
        messageProducer.send(notification);
        return null;
    }

    @Override
    public EntitiesGroup findById(Long id) {
        return null;
    }

    @Override
    public EntitiesGroup create(EntitiesGroup entitiesGroup) {
        return null;
    }

    @Override
    public EntitiesGroup update(Long id, EntitiesGroup entitiesGroup) {
        return null;
    }

    @Override
    public boolean delete(Long id) {
        return false;
    }
}
