package com.cvcorp.hotel.business.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class HotelNotfoundException extends RuntimeException {
    public HotelNotfoundException(Long id) {
        super(String.format("Hotel de id %d não encontrado", id));
    }
}
