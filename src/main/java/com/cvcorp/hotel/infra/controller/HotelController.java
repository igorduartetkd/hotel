package com.cvcorp.hotel.infra.controller;

import com.cvcorp.hotel.business.service.HotelService;
import com.cvcorp.hotel.domain.entity.HotelDetail;
import com.cvcorp.hotel.domain.entity.HotelSummary;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("hotels")
public class HotelController {

    private final HotelService hotelService;


    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping(path = "/{hotelId}")
    public ResponseEntity<?> findById(@PathVariable Long hotelId) {
        HotelDetail hotelDetail = hotelService.findById(hotelId);
        return ResponseEntity.ok(hotelDetail);
    }

    @GetMapping(path = "/avail/{cityId}")
    public ResponseEntity<?> findAllByCityId(@PathVariable Long cityId) {
        Set<HotelSummary> hotelSummarySet = hotelService.findAllByCityCode(cityId);
        return ResponseEntity.ok(hotelSummarySet);
    }

}
