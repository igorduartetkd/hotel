package com.cvcorp.hotel.domain.entity;


import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class Room extends BaseDomain {
    private final Long roomID;
    private final CategoryName categoryName;
    private final Price price;

    @Getter
    public enum CategoryName {
        STANDARD("Standard"),
        MASTER("Master"),
        DELUXE("Deluxe");

        private final String name;

        CategoryName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

}
