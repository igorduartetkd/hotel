package com.cvcorp.hotel.infra.database.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@Entity
@Table(name = "price")
@SuperBuilder
@Getter
@NoArgsConstructor
public class PriceEntity extends BaseEntity {
    @Column(precision = 10, scale = 2)
    private BigDecimal adult;

    @Column(precision = 10, scale = 2)
    private BigDecimal child;

}
