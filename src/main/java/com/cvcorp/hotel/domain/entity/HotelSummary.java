package com.cvcorp.hotel.domain.entity;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class HotelSummary extends BaseDomain {
    private final Long id;
    private final String name;
    private final Long cityCode;
}
