package com.sahaj.hms.service.operation.impl;

import com.sahaj.hms.domain.common.Floors;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.common.SubCorridor;
import com.sahaj.hms.service.operation.interfaces.FloorsOperation;
import com.sahaj.hms.service.operation.interfaces.HotelOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelOperationImpl implements HotelOperation {

    @Autowired
    private FloorsOperation floorsOperation;

    @Override
    public void saveEnergy(final Hotel hotel) {
        Floors floors = hotel.getFloors();
        floorsOperation.saveEnergy(floors);
    }

    /**
     * @param hotel
     */
    @Override
    public void revealCurrentStatus(final Hotel hotel) {
        floorsOperation.revealCurrentStatus(hotel.getFloors());
    }

    @Override
    public SubCorridor getSubCorridorById(Hotel hotel, Integer floorId, Integer subCorridorId) {
        return floorsOperation.getSubCorridorById(hotel.getFloors(), floorId, subCorridorId);
    }
}
