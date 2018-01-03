package com.sahaj.hms.service;

import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 * Starting point of the Program Execution.
 * <p>
 * This Class maintains {@link com.sahaj.hms.domain.common.Hotel} initialization using {@link HotelServiceImpl}
 * operations and maintains its equipment status using Rules
 */

@Service
public class EquipmentControllerImpl implements EquipmentController {

    @Autowired
    private HotelService hotelService;

    @Override
    public void control() {
        System.out.println("INSIDE CONTROL");

        Scanner in = new Scanner(System.in);

        System.out.print("Number Of Floors : ");
        int numberOfFloors = in.nextInt();

        System.out.print("Main Corridor per Floor : ");
        int mainCorridorPerFloor = in.nextInt();

        System.out.print("Sub Corridor per Floor : ");
        int subCorridorPerFloor = in.nextInt();

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(numberOfFloors, mainCorridorPerFloor, subCorridorPerFloor);
        hotelService.initializeHotel(hotelInitializationRequest);
    }
}
