package com.cvcorp.hotel.infra.database.repository;

import com.cvcorp.hotel.infra.database.entity.HotelEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface HotelEntityRepository extends BaseEntityRepository<HotelEntity> {
    @EntityGraph(attributePaths = {"city", "rooms"})
    @Override
    Optional<HotelEntity> findById(Long id);

    @EntityGraph(attributePaths = {"city"})
    Set<HotelEntity> findAllByCity_Id(Long cityId);
}
