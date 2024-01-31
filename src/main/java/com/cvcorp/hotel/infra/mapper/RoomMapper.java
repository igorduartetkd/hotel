package com.cvcorp.hotel.infra.mapper;

import com.cvcorp.hotel.domain.entity.Room;
import com.cvcorp.hotel.infra.database.entity.RoomEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class RoomMapper implements EntityToDomainMapper<Room, RoomEntity> {

    private final PriceMapper priceMapper;

    public RoomMapper(PriceMapper priceMapper) {
        this.priceMapper = priceMapper;
    }

    @Override
    public Optional<Room> toDomain(RoomEntity roomEntity) {
        return roomEntity == null ? Optional.empty() : Optional.of(Room.builder()
                .roomID(roomEntity.getId())
                .categoryName(roomEntity.getCategoryName())
                .price(priceMapper.toDomain(roomEntity.getPrice()).orElse(null))
                .build());
    }
}
