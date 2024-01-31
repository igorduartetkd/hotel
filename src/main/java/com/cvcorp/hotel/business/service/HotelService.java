package com.cvcorp.hotel.business.service;


import com.cvcorp.hotel.business.exception.HotelNotfoundException;
import com.cvcorp.hotel.domain.entity.HotelDetail;
import com.cvcorp.hotel.domain.entity.HotelSummary;
import com.cvcorp.hotel.infra.repository.HotelDetailRepositoryImpl;
import com.cvcorp.hotel.infra.repository.HotelSummaryRepositoryImpl;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class HotelService {

    private final HotelSummaryRepositoryImpl hotelSummaryRepository;
    private final HotelDetailRepositoryImpl hotelDetailRepository;

    public HotelService(
            HotelSummaryRepositoryImpl hotelSummaryRepository,
            HotelDetailRepositoryImpl hotelDetailRepository
    ) {
        this.hotelSummaryRepository = hotelSummaryRepository;
        this.hotelDetailRepository = hotelDetailRepository;
    }

    public HotelDetail findById(Long id) {
        return hotelDetailRepository.findById(id)
                .orElseThrow(() -> new HotelNotfoundException(id));
    }

    public Set<HotelSummary> findAllByCityCode(Long cityCode) {
        return hotelSummaryRepository.findAllByCityCode(cityCode);
    }
}
