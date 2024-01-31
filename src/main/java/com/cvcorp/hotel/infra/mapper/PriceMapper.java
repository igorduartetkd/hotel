package com.cvcorp.hotel.infra.mapper;

import com.cvcorp.hotel.domain.entity.Price;
import com.cvcorp.hotel.infra.database.entity.PriceEntity;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public final class PriceMapper implements EntityToDomainMapper<Price, PriceEntity> {
    @Override
    public Optional<Price> toDomain(PriceEntity priceEntity) {
        return priceEntity == null ? Optional.empty() : Optional.of(Price.builder()
                .adult(priceEntity.getAdult())
                .child(priceEntity.getChild())
                .build());
    }
}
