package com.cvcorp.hotel.domain.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Price extends BaseDomain {

    private final Float adult;
    private final Float child;
}
