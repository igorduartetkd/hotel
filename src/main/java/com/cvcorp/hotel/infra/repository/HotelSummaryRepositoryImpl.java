package com.cvcorp.hotel.infra.repository;

import com.cvcorp.hotel.domain.entity.HotelSummary;
import com.cvcorp.hotel.domain.repository.HotelSummaryRepository;
import com.cvcorp.hotel.infra.database.entity.HotelEntity;
import com.cvcorp.hotel.infra.database.repository.HotelEntityRepository;
import com.cvcorp.hotel.infra.mapper.HotelSummaryMapper;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class HotelSummaryRepositoryImpl implements HotelSummaryRepository {

    private final HotelEntityRepository hotelSummaryRepository;
    private final HotelSummaryMapper hotelSummaryMapper;

    public HotelSummaryRepositoryImpl(
            HotelEntityRepository hotelSummaryRepository,
            HotelSummaryMapper hotelSummaryMapper
    ) {
        this.hotelSummaryRepository = hotelSummaryRepository;
        this.hotelSummaryMapper = hotelSummaryMapper;
    }

    @Override
    public Set<HotelSummary> findAllByCityCode(Long cityCode) {
        Set<HotelEntity> hotelSummaries = hotelSummaryRepository.findAllByCity_Id(cityCode);
        return hotelSummaryMapper.toDomain(hotelSummaries);
    }
}
