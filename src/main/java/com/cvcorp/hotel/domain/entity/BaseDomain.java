package com.cvcorp.hotel.domain.entity;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public abstract class BaseDomain {

    private final Long id;
}
