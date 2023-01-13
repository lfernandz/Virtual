package com.seresco.milena.business.service.infrastructure.mapper;

import com.seresco.milena.business.service.domain.model.EntitiesGroup;
import com.seresco.milena.business.service.infrastructure.entities.EntitiesGroupEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EntitesGroupMapper {

    EntitesGroupMapper INSTANCE = Mappers.getMapper(EntitesGroupMapper.class);

    EntitiesGroup toDomain(EntitiesGroupEntity entity);

    EntitiesGroupEntity toEntity(EntitiesGroup entityGroup);

    List<EntitiesGroup> toDomain(List<EntitiesGroupEntity> entities);

    List<EntitiesGroupEntity> toEntity(List<EntitiesGroup> entitiesGroups);

}