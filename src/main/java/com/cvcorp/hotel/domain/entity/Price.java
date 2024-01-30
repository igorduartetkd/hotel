package com.cvcorp.hotel.domain.entity;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class Price extends BaseDomain {

    private final BigDecimal adult;
    private final BigDecimal child;
}
