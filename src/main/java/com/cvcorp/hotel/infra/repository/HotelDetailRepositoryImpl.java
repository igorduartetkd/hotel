package com.cvcorp.hotel.infra.repository;

import com.cvcorp.hotel.domain.entity.HotelDetail;
import com.cvcorp.hotel.domain.repository.HotelDetailRepository;
import com.cvcorp.hotel.infra.database.entity.HotelEntity;
import com.cvcorp.hotel.infra.database.repository.HotelEntityRepository;
import com.cvcorp.hotel.infra.mapper.HotelDetailMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class HotelDetailRepositoryImpl implements HotelDetailRepository {

    private final HotelEntityRepository hotelEntityRepository;
    private final HotelDetailMapper hotelDetailMapper;

    public HotelDetailRepositoryImpl(
            HotelEntityRepository hotelEntityRepository,
            HotelDetailMapper hotelDetailMapper
    ) {
        this.hotelEntityRepository = hotelEntityRepository;
        this.hotelDetailMapper = hotelDetailMapper;
    }

    @Override
    public Optional<HotelDetail> findById(Long id) {
        Optional<HotelEntity> hotelEntity = hotelEntityRepository.findById(id);
        return hotelDetailMapper.toDomain(hotelEntity);
    }
}
