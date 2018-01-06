package com.sahaj.hms.service.impl;

import com.sahaj.hms.domain.enums.MovementStatus;
import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import com.sahaj.hms.domain.sr.SensorInputRequest;
import com.sahaj.hms.exception.IncorrectSensorInputException;
import com.sahaj.hms.service.EquipmentController;
import com.sahaj.hms.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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
    public void control() throws IncorrectSensorInputException {
        Scanner in = new Scanner(System.in);

        // Initializing Equipments for the first time
        HotelInitializationRequest hotelInitializationRequest = getInitializationConfiguration(in);
        hotelService.initializeHotel(hotelInitializationRequest);

        while (true) {
            SensorInputRequest sensorInputRequest = getLatestEquipmentStatus(in);
            if (sensorInputRequest != null && sensorInputRequest.getCorridor() != 0) {
                hotelService.updateHotelEquipmentState(sensorInputRequest);
            }
        }
    }

    private HotelInitializationRequest getInitializationConfiguration(final Scanner in) {
        System.out.println();
        System.out.print("Number Of Floors : ");
        int numberOfFloors = in.nextInt();
        in.nextLine();

        System.out.print("Main Corridor per Floor : ");
        int mainCorridorPerFloor = in.nextInt();

        System.out.print("Sub Corridor per Floor : ");
        int subCorridorPerFloor = in.nextInt();

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(numberOfFloors, mainCorridorPerFloor, subCorridorPerFloor);
        return hotelInitializationRequest;
    }

    private SensorInputRequest getLatestEquipmentStatus(final Scanner in) throws IncorrectSensorInputException {
        String sensorInput = in.nextLine();
        if (StringUtils.isEmpty(sensorInput)) {
            return null;
        }

        System.out.println("Subsequent Inputs from Sensors : ");
        String[] commands = sensorInput.split(",");
        MovementStatus movementStatus = MovementStatus.DEFAULT;
        Integer floorNumber = 0;
        Integer subCorridorNo = 0;

        if (commands[0].toLowerCase().contains("No movement in Floor".toLowerCase())) {
            movementStatus = MovementStatus.NO_MOVEMENT;
            floorNumber = new Integer(commands[0].replaceAll("No movement in Floor", "").trim());
        } else if (commands[0].toLowerCase().contains("Movement in Floor".toLowerCase())) {
            movementStatus = MovementStatus.MOVEMENT;
            floorNumber = new Integer(commands[0].replaceAll("Movement in Floor", "").trim());
        }

        if (commands[1].toLowerCase().contains("Sub corridor".toLowerCase())) {
            String subCorridor = commands[1].replaceAll("Sub corridor", "").trim();
            subCorridor = subCorridor.replaceAll("for a minute", "").trim();
            subCorridorNo = new Integer(subCorridor);
        }

        // If data is not pursed properly
        if (floorNumber == 0 || subCorridorNo == 0) {
            throw new IncorrectSensorInputException(sensorInput);
        }
        SensorInputRequest sensorInputRequest = new SensorInputRequest
                .SensorInputRequestBuilder(movementStatus, floorNumber, subCorridorNo).construct();
        return sensorInputRequest;
    }
}
