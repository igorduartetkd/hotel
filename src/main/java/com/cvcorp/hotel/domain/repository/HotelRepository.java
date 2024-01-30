package com.cvcorp.hotel.domain.repository;

import com.cvcorp.hotel.domain.entity.Hotel;

import java.util.Optional;
import java.util.Set;

public interface HotelRepository extends BaseDomainRepository<Hotel> {
    Optional<Hotel> findById(Long id);

    Set<Hotel> findAllByCityCode(Long cityCode);
}
