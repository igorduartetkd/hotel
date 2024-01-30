package com.cvcorp.hotel.domain.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {

    private final Float adult;
    private final Float child;
}
