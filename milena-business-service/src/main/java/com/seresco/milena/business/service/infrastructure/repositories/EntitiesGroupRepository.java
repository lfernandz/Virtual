package com.seresco.milena.business.service.infrastructure.repositories;

import com.seresco.milena.business.service.infrastructure.entities.EntitiesGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntitiesGroupRepository extends JpaRepository<EntitiesGroupEntity, Long> {
}
