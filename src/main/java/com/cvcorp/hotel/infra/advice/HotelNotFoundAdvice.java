package com.cvcorp.hotel.infra.advice;


import com.cvcorp.hotel.business.exception.HotelNotfoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HotelNotFoundAdvice {

    @ExceptionHandler(HotelNotfoundException.class)
    ResponseEntity<?> hotelNotfoundException(HotelNotfoundException hotelNotfoundException) {
        Map<String, Object> error = new HashMap<>();
        error.put("status", HttpStatus.NOT_FOUND.value());
        error.put("message", hotelNotfoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
}
