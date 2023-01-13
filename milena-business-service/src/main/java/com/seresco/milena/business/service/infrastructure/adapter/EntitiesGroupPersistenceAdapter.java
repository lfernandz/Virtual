package com.seresco.milena.business.service.infrastructure.adapter;

import com.seresco.milena.business.service.domain.port.EntitiesGroupPersistencePort;
import com.seresco.milena.business.service.domain.model.EntitiesGroup;
import com.seresco.milena.business.service.infrastructure.entities.EntitiesGroupEntity;
import com.seresco.milena.business.service.infrastructure.mapper.EntitesGroupMapper;
import com.seresco.milena.business.service.infrastructure.repositories.EntitiesGroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntitiesGroupPersistenceAdapter implements EntitiesGroupPersistencePort {

    @Autowired
    private EntitiesGroupRepository repository;

    public EntitiesGroupPersistenceAdapter(){}

    @Override
    public List<EntitiesGroup> findAll() {
        return EntitesGroupMapper.INSTANCE.toDomain(repository.findAll());
    }

    @Override
    public EntitiesGroup findById(Long id) {
        if(repository.findById(id).isPresent())
            return EntitesGroupMapper.INSTANCE.toDomain(repository.findById(id).get());
        return null;
    }

    @Override
    public EntitiesGroup create(EntitiesGroup entitiesGroup) {
        EntitiesGroupEntity entity = EntitesGroupMapper.INSTANCE.toEntity(entitiesGroup);
        entity = repository.save(entity);
        return EntitesGroupMapper.INSTANCE.toDomain(entity);
    }

    @Override
    public boolean delete(Long id) {
        if(repository.findById(id).isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
