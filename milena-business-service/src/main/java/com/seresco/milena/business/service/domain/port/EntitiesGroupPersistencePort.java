package com.seresco.milena.business.service.domain.port;

import com.seresco.milena.business.service.domain.model.EntitiesGroup;

import java.util.List;

public interface EntitiesGroupPersistencePort {

    List<EntitiesGroup> findAll();

    EntitiesGroup findById(Long id);

    EntitiesGroup create(EntitiesGroup entitiesGroup);

    boolean delete(Long id);

}
