package com.cvcorp.hotel.infra.mapper;

import com.cvcorp.hotel.domain.entity.HotelDetail;
import com.cvcorp.hotel.infra.database.entity.HotelEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class HotelDetailMapper implements EntityToDomainMapper<HotelDetail, HotelEntity> {

    private final RoomMapper roomMapper;

    public HotelDetailMapper(RoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }

    @Override
    public Optional<HotelDetail> toDomain(HotelEntity hotelEntity) {
        return hotelEntity == null ? Optional.empty() : Optional.of(HotelDetail.builder()
                .id(hotelEntity.getId())
                .name(hotelEntity.getName())
                .cityCode(hotelEntity.getCity().getId())
                .cityName(hotelEntity.getCity().getName())
                .rooms(roomMapper.toDomain(hotelEntity.getRooms()))
                .build());
    }
}
