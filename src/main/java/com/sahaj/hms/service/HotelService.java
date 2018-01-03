package com.sahaj.hms.service;

import com.sahaj.hms.domain.sr.HotelInitializationRequest;

/**
 * Interface which provides operations to initialize and manage hotel equipment services
 */
public interface HotelService {
    public Boolean initializeHotel(HotelInitializationRequest hotelInitializationRequest);
}
