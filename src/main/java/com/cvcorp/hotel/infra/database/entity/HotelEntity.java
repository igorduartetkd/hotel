package com.cvcorp.hotel.infra.database.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "hotel")
@Getter
@NoArgsConstructor
@SuperBuilder
public class HotelEntity extends BaseEntity {

    @Column(length = 100, nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private CityEntity city;

    @OneToMany(mappedBy = "hotel", cascade = CascadeType.REMOVE)
    private Set<RoomEntity> rooms = new HashSet<>();
}
