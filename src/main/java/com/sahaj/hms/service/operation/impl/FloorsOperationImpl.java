package com.sahaj.hms.service.operation.impl;

import com.sahaj.hms.domain.common.Floor;
import com.sahaj.hms.domain.common.Floors;
import com.sahaj.hms.domain.common.SubCorridor;
import com.sahaj.hms.service.operation.interfaces.FloorOperation;
import com.sahaj.hms.service.operation.interfaces.FloorsOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorsOperationImpl implements FloorsOperation {

    @Autowired
    private FloorOperation floorOperation;

    @Override
    public boolean saveEnergy(final Floors floors) {
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
    public void revealCurrentStatus(final Floors floors) {
        List<Floor> floorList = floors.getFloors();
        for (int i = 0; i < floorList.size(); i++) {
            Floor floor = floorList.get(i);
            floorOperation.revealCurrentStatus(floor);
        }
    }


    @Override
    public SubCorridor getSubCorridorById(Floors floors, Integer floorId, Integer subCorridorId) {
        Floor floor = getFloorById(floors, floorId);

        List<SubCorridor> subCorridorList = floor.getSubCorridors();
        SubCorridor subCorridor = null;

        for (SubCorridor sc : subCorridorList) {
            if (sc.getCorridorId().equals(subCorridorId)) {
                subCorridor = sc;
                break;
            }
        }
        return subCorridor;
    }

    @Override
    public Floor getFloorById(Floors floors, Integer floorId) {
        Floor floorToBeSearched = null;
        List<Floor> floorList = floors.getFloors();
        for (Floor floor : floorList) {
            if (floor.getFloorId().equals(floorId)) {
                floorToBeSearched = floor;
            }
        }
        return floorToBeSearched;
    }
}
