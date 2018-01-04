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
        Scanner in = new Scanner(System.in);

        // Initializing Equipments for the first time
        init(in);

        while(true) {
            updateEquipmentStatus(in);
        }

    }

    /**
     *
     * @param in
     */
    private void init(final Scanner in) {
        System.out.println("***********************************");
        System.out.println();
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

    /**
     *
     * @param in
     */

    private void updateEquipmentStatus(final Scanner in) {
        System.out.println("Subsequent Inputs from Sensors : ");

        String sensorInput = in.nextLine();
        String [] commands = sensorInput.split(",");

        if(commands[0].toLowerCase().contains("Movement in Floor".toLowerCase())) {
            int floorNumber = new Integer(commands[0].replaceAll("Movement in Floor", "").trim());

            if(commands[1].toLowerCase().contains("Sub corridor".toLowerCase())) {
                int subCorridorNo = new Integer(commands[1].replaceAll("Sub corridor", "").trim());
            }
        }
    }
}
