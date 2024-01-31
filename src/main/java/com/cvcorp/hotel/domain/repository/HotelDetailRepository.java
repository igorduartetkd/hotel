package com.cvcorp.hotel.domain.repository;

import com.cvcorp.hotel.domain.entity.HotelDetail;

import java.util.Optional;

public interface HotelDetailRepository extends BaseDomainRepository<HotelDetail> {
    Optional<HotelDetail> findById(Long id);
}
