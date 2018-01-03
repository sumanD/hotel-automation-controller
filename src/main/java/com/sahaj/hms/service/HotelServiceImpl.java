package com.sahaj.hms.service;

import com.sahaj.hms.common.HotelFactory;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to Construct Hotel Object from the 1st Input data provided by the Client
 */

@Service("hotelService")
public class HotelServiceImpl implements HotelService {

    private Hotel hotel;


    @Override
    public Boolean initializeHotel(HotelInitializationRequest hotelInitializationRequest) {
        // TODO Validate

        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);
        hotel.printState();

        return null;
    }
}
