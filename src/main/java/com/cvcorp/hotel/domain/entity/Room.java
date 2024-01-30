package com.cvcorp.hotel.domain.entity;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Data
@Builder
public class Room {
    private final String roomID;
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
