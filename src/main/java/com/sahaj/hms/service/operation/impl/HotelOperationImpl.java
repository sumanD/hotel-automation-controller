package com.sahaj.hms.service.operation.impl;

import com.sahaj.hms.domain.common.Floors;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.common.SubCorridor;
import com.sahaj.hms.service.operation.interfaces.FloorsOperation;
import com.sahaj.hms.service.operation.interfaces.HotelOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to operate on Hotel Equipments
 */
@Service
public class HotelOperationImpl implements HotelOperation {

    @Autowired
    private FloorsOperation floorsOperation;

    /**
     * This operation do the needful to control the excessive electricity usage by the
     * Hotel's Electrical equipments ({@link com.sahaj.hms.domain.equipment.Light}
     * and {@link com.sahaj.hms.domain.equipment.AirConditioner})
     *
     * @param hotel A Hotel Object whose equipments electricity usage needs to be controlled
     */
    @Override
    public boolean saveEnergy(final Hotel hotel) {
        Floors floors = hotel.getFloors();
        return floorsOperation.saveEnergy(floors);
    }

    /**
     * Print's the current electrical equipment status {@link com.sahaj.hms.domain.enums.EquipmentState} by
     * {@link com.sahaj.hms.domain.common.Floor}, {@link com.sahaj.hms.domain.common.MainCorridor} and
     * {@link SubCorridor}
     *
     * @param hotel A Hotel Object whose equipments status needs to be printed
     */
    @Override
    public void revealCurrentStatus(final Hotel hotel) {
        floorsOperation.revealCurrentStatus(hotel.getFloors());
    }

    /**
     * Returns the {@link SubCorridor} of a {@link Hotel}
     *
     * @param hotel         The {@link Hotel} having the {@link SubCorridor}
     * @param floorId       The Id of the {@link com.sahaj.hms.domain.common.Floor} having the {@link SubCorridor}
     * @param subCorridorId The Id of the {@link SubCorridor}
     * @return Matched {@link SubCorridor}
     */
    @Override
    public SubCorridor getSubCorridorById(Hotel hotel, Integer floorId, Integer subCorridorId) {
        return floorsOperation.getSubCorridorById(hotel.getFloors(), floorId, subCorridorId);
    }
}
