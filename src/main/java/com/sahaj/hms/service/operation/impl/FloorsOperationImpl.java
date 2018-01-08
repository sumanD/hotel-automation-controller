package com.sahaj.hms.service.operation.impl;

import com.sahaj.hms.domain.common.Floor;
import com.sahaj.hms.domain.common.Floors;
import com.sahaj.hms.domain.common.SubCorridor;
import com.sahaj.hms.exception.ValidationException;
import com.sahaj.hms.service.operation.interfaces.FloorOperation;
import com.sahaj.hms.service.operation.interfaces.FloorsOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorsOperationImpl implements FloorsOperation {

    @Autowired
    private FloorOperation floorOperation;

    /**
     * This operation do the needful to control the excessive electricity usage by the
     * Hotel's Electrical equipments ({@link com.sahaj.hms.domain.equipment.Light}
     * and {@link com.sahaj.hms.domain.equipment.AirConditioner})
     *
     * @param floors A Floors Object whose equipments electricity usage needs to be controlled
     */
    @Override
    public boolean saveEnergy(final Floors floors) throws ValidationException {
        if (floors == null) {
            final String errorMessage = "saveEnergy() Operation has failed on Floors Object. " +
                    "Reason - Floors object provided is null";
            throw new ValidationException(errorMessage);
        }

        boolean hasEnergySaved = false;
        List<Floor> floorList = floors.getFloors();
        for (Floor floor : floorList) {
            hasEnergySaved = floorOperation.saveEnergy(floor);
        }
        return hasEnergySaved;
    }

    /**
     * Prints Equipment Status of hotel's Floors
     *
     * @param floors Floors Object where each floor's Equipment state needs to be revealed
     */
    @Override
    public void revealCurrentStatus(final Floors floors) throws ValidationException {
        if (floors == null) {
            final String errorMessage = "revealCurrentStatus() Operation has failed on Floors Object. " +
                    "Reason - Floors object provided is null";
            throw new ValidationException(errorMessage);
        }

        List<Floor> floorList = floors.getFloors();
        for (int i = 0; i < floorList.size(); i++) {
            Floor floor = floorList.get(i);
            floorOperation.revealCurrentStatus(floor);
        }
    }


    @Override
    public SubCorridor getSubCorridorById(final Floors floors, final Integer floorId, final Integer subCorridorId)
            throws ValidationException {
        if (floors == null) {
            final String errorMessage = "getSubCorridorById() Operation has failed on Floors Object. " +
                    "Reason - Floors object provided is null";
            throw new ValidationException(errorMessage);
        }

        if (floorId == null || floorId.intValue() == 0 || subCorridorId == null || subCorridorId.intValue() == 0) {
            final String errorMessage = "getSubCorridorById() Operation has failed on floorId/SubCorridorId Objects. " +
                    "Reason - floorId/SubCorridorId Objects provided are null/0.";
            throw new ValidationException(errorMessage);
        }

        Floor floor = getFloorById(floors, floorId);

        SubCorridor subCorridor = null;
        if (floor != null) {
            List<SubCorridor> subCorridorList = floor.getSubCorridors();
            for (SubCorridor sc : subCorridorList) {
                if (sc.getCorridorId().equals(subCorridorId)) {
                    subCorridor = sc;
                    break;
                }
            }
        }
        return subCorridor;
    }

    @Override
    public Floor getFloorById(final Floors floors, final Integer floorId) throws ValidationException {
        if (floors == null) {
            final String errorMessage = "getFloorById() Operation has failed on Floors Object. " +
                    "Reason - Floors object provided is null";
            throw new ValidationException(errorMessage);
        }

        if (floorId == null || floorId.intValue() == 0) {
            final String errorMessage = "getFloorById() Operation has failed on floorId Object. " +
                    "Reason - floorId Object provided are null/0.";
            throw new ValidationException(errorMessage);
        }

        List<Floor> floorList = floors.getFloors();
        for (Floor floor : floorList) {
            if (floor.getFloorId().intValue() == floorId.intValue()) {
                return floor;
            }
        }
        return null;
    }
}
