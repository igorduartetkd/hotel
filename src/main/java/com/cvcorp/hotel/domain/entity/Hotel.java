package com.cvcorp.hotel.domain.entity;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@SuperBuilder
public class Hotel extends BaseDomain {
    private final Long id;
    private final String name;
    private final Long cityCode;
    private final String cityName;
    private final Set<Room> rooms;

}
