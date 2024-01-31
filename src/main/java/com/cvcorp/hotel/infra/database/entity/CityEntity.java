package com.cvcorp.hotel.infra.database.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "city")
@Getter
@NoArgsConstructor
@SuperBuilder
public class CityEntity extends BaseEntity {
    @Column(length = 60)
    private String name;

    @OneToMany(mappedBy = "city")
    private Set<HotelEntity> hotels = new HashSet<>();
}
