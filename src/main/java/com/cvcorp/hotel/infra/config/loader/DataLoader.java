package com.cvcorp.hotel.infra.config.loader;

import com.cvcorp.hotel.domain.entity.Room;
import com.cvcorp.hotel.infra.database.entity.CityEntity;
import com.cvcorp.hotel.infra.database.entity.HotelEntity;
import com.cvcorp.hotel.infra.database.entity.PriceEntity;
import com.cvcorp.hotel.infra.database.entity.RoomEntity;
import com.cvcorp.hotel.infra.database.repository.CityEntityRepository;
import com.cvcorp.hotel.infra.database.repository.HotelEntityRepository;
import com.cvcorp.hotel.infra.database.repository.PriceEntityRepository;
import com.cvcorp.hotel.infra.database.repository.RoomEntityRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class DataLoader {
    private final HotelEntityRepository hotelRepository;
    private final CityEntityRepository cityRepository;
    private final RoomEntityRepository roomRepository;
    private final PriceEntityRepository priceRepository;
    private final String portoSeguroName = "Porto Seguro";
    private final String rioDeJaneiroName = "Rio de Janeiro";
    private final String saoPauloName = "São Paulo";
    private final Random random = new Random();

    public DataLoader(
            HotelEntityRepository hotelRepository,
            CityEntityRepository cityRepository,
            RoomEntityRepository roomRepository,
            PriceEntityRepository priceEntityRepository
    ) {
        this.hotelRepository = hotelRepository;
        this.cityRepository = cityRepository;
        this.roomRepository = roomRepository;
        this.priceRepository = priceEntityRepository;
    }

    @PostConstruct
    public void loadHotels() {
        Map<String, CityEntity> cities = createCities();


        HotelEntity hotel = HotelEntity.builder()
                .city(cities.get(portoSeguroName))
                .name("Best Western Shalimar Praia Hotel")
                .build();

        HotelEntity hotel2 = HotelEntity.builder()
                .city(cities.get(portoSeguroName))
                .name("Hotel Brisa da Praia")
                .build();


        HotelEntity hotel3 = HotelEntity.builder()
                .city(cities.get(rioDeJaneiroName))
                .name("Plaza Spania Boutique Hotel")
                .build();

        HotelEntity hotel4 = HotelEntity.builder()
                .city(cities.get(rioDeJaneiroName))
                .name("Pontal Beach Resort Apt na Orla com Vista Recreio")
                .build();


        HotelEntity hotel5 = HotelEntity.builder()
                .city(cities.get(saoPauloName))
                .name("Plaza Spania Boutique Hotel")
                .build();

        HotelEntity hotel6 = HotelEntity.builder()
                .city(cities.get(saoPauloName))
                .name("Pontal Beach Resort Apt na Orla com Vista Recreio")
                .build();

        List<HotelEntity> hotels = hotelRepository.saveAll(Arrays.asList(
                hotel,
                hotel2,
                hotel3,
                hotel4,
                hotel5,
                hotel6));

        createAllRooms(hotels);
        hotelRepository.saveAll(hotels);

    }

    private Map<String, CityEntity> createCities() {
        CityEntity portoSeguro = CityEntity.builder()
                .id(1032L)
                .name(portoSeguroName).build();
        CityEntity rioDeJaneiro = CityEntity.builder()
                .id(7110L)
                .name(rioDeJaneiroName).build();
        CityEntity saoPaulo = CityEntity.builder()
                .id(9626L)
                .name(saoPauloName).build();

        return Stream.of(portoSeguro, rioDeJaneiro, saoPaulo)
                .map(cityRepository::save)
                .collect(Collectors.toMap(CityEntity::getName, city -> city));
    }

    private void createAllRooms(List<HotelEntity> hotels) {
        hotels.forEach(this::createRooms);
    }

    private void createRooms(HotelEntity hotelEntity) {
        for (int i = 0; i < 2; i++) {
            PriceEntity price = createPrice();
            RoomEntity room = RoomEntity.builder()
                    .categoryName(Room.CategoryName.values()[random.nextInt(Room.CategoryName.values().length)])
                    .hotel(hotelEntity)
                    .price(price)
                    .build();

            roomRepository.save(room);
        }

    }

    private PriceEntity createPrice() {
        PriceEntity price = PriceEntity.builder()
                .adult(BigDecimal.valueOf(random.nextDouble() * 100))
                .child(BigDecimal.valueOf(random.nextDouble() * 50))
                .build();
        priceRepository.save(price);
        return price;
    }
}
