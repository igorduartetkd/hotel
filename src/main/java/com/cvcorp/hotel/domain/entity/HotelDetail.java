package com.cvcorp.hotel.domain.entity;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Getter
@SuperBuilder
public class HotelDetail extends HotelSummary {
    private final String cityName;
    private final Set<Room> rooms;
}
