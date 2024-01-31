package com.cvcorp.hotel.infra.database.entity;


import com.cvcorp.hotel.domain.entity.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "room")
@Getter
@NoArgsConstructor
@SuperBuilder
public class RoomEntity extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private Room.CategoryName categoryName;

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "price_id")
    private PriceEntity price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hotel_id")
    private HotelEntity hotel;
}
