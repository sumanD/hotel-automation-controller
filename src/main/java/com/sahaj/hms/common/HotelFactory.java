package com.sahaj.hms.common;

import com.sahaj.hms.domain.common.Floor;
import com.sahaj.hms.domain.common.Floors;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public final class HotelFactory {
    public static Hotel construct(HotelInitializationRequest hotelInitializationRequest) {

        Integer numberOfFloors = hotelInitializationRequest.getNumberOfFloors();
        Integer numberOfMainCorridorPerFloor = hotelInitializationRequest.getNumberOfMainCorridorsPerFloor();
        Integer numberOfSubCorridorPerFloor = hotelInitializationRequest.getNumberOfSubCorridorsPerFloor();

        List<Floor> floorList = new ArrayList<>(numberOfFloors);
        for (Integer i = 0; i < numberOfFloors; i++) {
            Floor floor = new Floor.FloorBuilder(numberOfMainCorridorPerFloor, numberOfSubCorridorPerFloor).construct();
            floorList.add(floor);
        }

        Floors floors = new Floors.FloorsBuilder(floorList).construct();

        Hotel hotel = new Hotel(floors);
        return hotel;
    }
}
