package com.cvcorp.hotel.domain.entity;

import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class Price extends BaseDomain {

    private final Float adult;
    private final Float child;
}
