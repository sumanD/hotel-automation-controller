package com.sahaj.hms.service.operation.impl;

import com.sahaj.hms.common.HotelFactory;
import com.sahaj.hms.domain.common.Floor;
import com.sahaj.hms.domain.common.Floors;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.common.SubCorridor;
import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import com.sahaj.hms.exception.ValidationException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FloorOperationImplTest {

    private FloorOperationImpl floorOperation;

    @Before
    public void setUp() {
        floorOperation = new FloorOperationImpl();
    }

    @Test
    public void testSaveEnergyWhenFloorsEnergyUsageLimitIsEqualToTheAllowedLimit() throws ValidationException {
        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);

        Floors floors = hotel.getFloors();
        List<Floor> floorList = floors.getFloors();

        for (Floor floor : floorList) {
            boolean hasSavedEnergy = floorOperation.saveEnergy(floor);
            Assert.assertFalse(hasSavedEnergy);
        }
    }

    @Test
    public void testSaveEnergyWhenFloorsEnergyUsageLimitIsLessThanTheAllowedLimit() throws ValidationException {
        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 2);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);

        Floors floors = hotel.getFloors();
        List<Floor> floorList = floors.getFloors();

        for (Floor floor : floorList) {
            boolean hasSavedEnergy = floorOperation.saveEnergy(floor);
            Assert.assertFalse(hasSavedEnergy);

            // Switching Off the AC's of all the SubCorridors
            for (SubCorridor subCorridor : floor.getSubCorridors()) {
                subCorridor.getAirConditioner().switchOff();
            }

            hasSavedEnergy = floorOperation.saveEnergy(floor);
            Assert.assertTrue(hasSavedEnergy);

        }
    }

    @Test
    public void testSaveEnergyWhenFloorsEnergyUsageLimitIsMoreThanTheAllowedLimit() throws ValidationException {
        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 2);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);

        Floors floors = hotel.getFloors();
        List<Floor> floorList = floors.getFloors();

        for (Floor floor : floorList) {
            boolean hasSavedEnergy = floorOperation.saveEnergy(floor);
            Assert.assertFalse(hasSavedEnergy);

            // Switching ON the Lights of all the SubCorridors
            for (SubCorridor subCorridor : floor.getSubCorridors()) {
                subCorridor.getLight().switchOn();
            }

            hasSavedEnergy = floorOperation.saveEnergy(floor);
            Assert.assertTrue(hasSavedEnergy);
        }
    }
}