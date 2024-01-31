package com.cvcorp.hotel.domain.repository;

import com.cvcorp.hotel.domain.entity.HotelSummary;

import java.util.Set;

public interface HotelSummaryRepository extends BaseDomainRepository<HotelSummary> {
    Set<HotelSummary> findAllByCityCode(Long cityCode);
}
