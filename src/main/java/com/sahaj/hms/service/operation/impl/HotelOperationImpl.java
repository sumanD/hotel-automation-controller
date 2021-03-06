package com.sahaj.hms.service.operation.impl;

import com.sahaj.hms.domain.common.Floors;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.common.SubCorridor;
import com.sahaj.hms.exception.HmsBaseException;
import com.sahaj.hms.exception.ValidationException;
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
    public boolean saveEnergy(final Hotel hotel) throws ValidationException {
        if (hotel == null) {
            final String errorMessage = "saveEnergy() Operation has failed on Hotel Object. " +
                    "Reason - Hotel object provided is null";
            throw new ValidationException(errorMessage);
        }

        Floors floors = hotel.getFloors();
        return floorsOperation.saveEnergy(floors);
    }

    /**
     * Print the current electrical equipment status {@link com.sahaj.hms.domain.enums.EquipmentState} by
     * {@link com.sahaj.hms.domain.common.Floor}, {@link com.sahaj.hms.domain.common.MainCorridor} and
     * {@link SubCorridor}
     *
     * @param hotel A Hotel Object whose equipments status needs to be printed
     */
    @Override
    public void revealCurrentStatus(final Hotel hotel) throws ValidationException {
        if (hotel == null) {
            final String errorMessage = "revealCurrentStatus() Operation has failed on Hotel Object. " +
                    "Reason - Hotel object provided is null";
            throw new ValidationException(errorMessage);
        }
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
    public SubCorridor getSubCorridorById(final Hotel hotel, final Integer floorId, final Integer subCorridorId)
            throws ValidationException {
        if (hotel == null) {
            final String errorMessage = "getSubCorridorById() Operation has failed on Hotel Object. " +
                    "Reason - Hotel object provided is null";
            throw new ValidationException(errorMessage);
        }

        if (floorId == null || floorId.intValue() == 0 || subCorridorId == null || subCorridorId.intValue() == 0) {
            final String errorMessage = "getSubCorridorById() Operation has failed on floorId/SubCorridorId Objects. " +
                    "Reason - floorId/SubCorridorId Objects provided are null/0.";
            throw new ValidationException(errorMessage);
        }

        return floorsOperation.getSubCorridorById(hotel.getFloors(), floorId, subCorridorId);
    }
}
