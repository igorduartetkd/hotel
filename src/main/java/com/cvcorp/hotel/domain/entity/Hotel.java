package com.cvcorp.hotel.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
public class Hotel extends BaseDomain {
    private final Long id;
    private final String name;
    private final Long cityCode;
    private final String cityName;
    private final Set<Room> rooms;

}
