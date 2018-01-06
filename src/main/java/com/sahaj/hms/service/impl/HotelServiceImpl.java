package com.sahaj.hms.service.impl;

import com.sahaj.hms.common.HotelFactory;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.common.SubCorridor;
import com.sahaj.hms.domain.enums.MovementStatus;
import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import com.sahaj.hms.domain.sr.SensorInputRequest;
import com.sahaj.hms.service.HotelService;
import com.sahaj.hms.service.operation.interfaces.HotelOperation;
import com.sahaj.hms.util.PowerConsumptionCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to Construct Hotel Object from the 1st Input data provided by the Client
 */

@Service("hotelService")
public class HotelServiceImpl implements HotelService {

    private Hotel hotel;
    private Integer maxAllowedPowerConsumptionLimit;

    @Autowired
    private HotelOperation hotelOperation;

    @Override
    public Boolean initializeHotel(HotelInitializationRequest hotelInitializationRequest) {
        hotel = HotelFactory.construct(hotelInitializationRequest);
        maxAllowedPowerConsumptionLimit = PowerConsumptionCalculator.calculateMaxAllowedPowerLimit(hotelInitializationRequest);
        hotelOperation.revealCurrentStatus(hotel);
        return true;
    }

    @Override
    public Boolean updateHotelEquipmentState(SensorInputRequest sensorInputRequest) {

        MovementStatus movementStatus = sensorInputRequest.getMovementStatus();
        Integer onWhichFloor = sensorInputRequest.getFloorNumber();
        Integer onWhichSubCorridor = sensorInputRequest.getCorridor();

        // Reset the Light of the Sub Corridor Depending on the Movement in Sub-Corridor
        SubCorridor subCorridor = hotelOperation.getSubCorridorById(hotel, onWhichFloor, onWhichSubCorridor);
        if (movementStatus == MovementStatus.MOVEMENT) {
            subCorridor.getLight().switchOn();
        } else if (movementStatus == MovementStatus.NO_MOVEMENT) {
            subCorridor.getLight().switchOff();
        }

        // Switch Off Other Floor's Equipments
        hotelOperation.saveEnergy(hotel);

        // Displays the current Equipment Status
        hotelOperation.revealCurrentStatus(hotel);

        return true;
    }
}
