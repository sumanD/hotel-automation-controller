package com.sahaj.hms.service;

import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import com.sahaj.hms.domain.sr.SensorInputRequest;

/**
 * Interface which provides operations to initialize and manage hotel equipment services
 */
public interface HotelService {
    public Boolean initializeHotel(HotelInitializationRequest hotelInitializationRequest);
    public Boolean updateHotelEquipmentState(SensorInputRequest sensorInputRequest);
}
