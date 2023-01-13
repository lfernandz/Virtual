package com.seresco.milena.business.service.domain.service;

import com.seresco.milena.business.service.domain.model.EntitiesGroup;

import java.util.List;

public interface EntitiesGroupService {

    List<EntitiesGroup> findAll();

    EntitiesGroup findById(Long id);

    EntitiesGroup create(EntitiesGroup entitiesGroup);

    EntitiesGroup update(Long id, EntitiesGroup entitiesGroup);

    boolean delete(Long id);

}
