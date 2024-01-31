package com.cvcorp.hotel.infra.mapper;

import com.cvcorp.hotel.domain.entity.HotelSummary;
import com.cvcorp.hotel.infra.database.entity.HotelEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class HotelSummaryMapper implements EntityToDomainMapper<HotelSummary, HotelEntity> {
    @Override
    public Optional<HotelSummary> toDomain(HotelEntity hotelEntity) {
        return hotelEntity == null ? Optional.empty() : Optional.of(HotelSummary.builder()
                .id(hotelEntity.getId())
                .name(hotelEntity.getName())
                .cityCode(hotelEntity.getCity().getId())
                .build());
    }
}
