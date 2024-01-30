package com.cvcorp.hotel.infra.database.repository;

import com.cvcorp.hotel.infra.database.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaseEntityRepository<E extends BaseEntity> extends JpaRepository<E, Long> {
}
