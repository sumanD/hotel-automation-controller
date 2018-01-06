package com.sahaj.hms.domain.common;

import com.sahaj.hms.common.Builder;

import java.util.ArrayList;
import java.util.List;

/**
 * The {@link Floor} class represent a hotel floor.
 * <p>
 * A {@link Floor} entity consists of List of {@link MainCorridor} and {@link SubCorridor}
 * <p>
 * This class provides methods to operate on {@link MainCorridor} list and {@link SubCorridor} list of a {@link Floor}
 */
public class Floor {
    private static Integer floorCounter = 1;

    private Integer floorId;
    private List<MainCorridor> mainCorridors;
    private List<SubCorridor> subCorridors;
    private Integer maxAllowedPowerConsumptionLimitPerFloor;

    private Floor(Integer floorId,
                  List<MainCorridor> mainCorridors,
                  List<SubCorridor> subCorridors,
                  Integer maxAllowedPowerConsumptionLimitPerFloor) {
        this.floorId = floorId;
        this.mainCorridors = mainCorridors;
        this.subCorridors = subCorridors;
        this.maxAllowedPowerConsumptionLimitPerFloor = maxAllowedPowerConsumptionLimitPerFloor;
    }

    public List<MainCorridor> getMainCorridors() {
        return mainCorridors;
    }

    public List<SubCorridor> getSubCorridors() {
        return subCorridors;
    }

    public Integer getFloorId() {
        return this.floorId;
    }

    public Integer getMaxAllowedPowerConsumptionLimitPerFloor() {
        return maxAllowedPowerConsumptionLimitPerFloor;
    }

    /**
     * Total Power consumption at a particular moment
     * @return
     */
    public Integer getRealTimeTotalPowerConsumption() {
        Integer totalFloorPowerConsumption = 0;

        for (MainCorridor mainCorridor : mainCorridors) {
            totalFloorPowerConsumption += mainCorridor.getTotalPowerConsumption();
        }

        for (SubCorridor subCorridor : subCorridors) {
            totalFloorPowerConsumption += subCorridor.getCurrentTotalPowerConsumption();
        }

        return totalFloorPowerConsumption;
    }

    public static class FloorBuilder implements Builder<Floor> {
        private Integer floorId;
        private List<MainCorridor> mainCorridors;
        private List<SubCorridor> subCorridors;
        private Integer maxPowerForFloor;

        public FloorBuilder(Integer numberOfMainCorridor, Integer numberOfSubCorridors) {
            Integer maxPowerNeeded = 0;

            mainCorridors = new ArrayList<>(numberOfMainCorridor);
            for (Integer i = 1; i <= numberOfMainCorridor; i++) {
                MainCorridor mainCorridor = new MainCorridor.MainCorridorBuilder(i).construct();
                maxPowerNeeded += mainCorridor.getTotalPowerConsumption();
                mainCorridors.add(mainCorridor);
            }

            subCorridors = new ArrayList<>(numberOfSubCorridors);
            for (Integer i = 1; i <= numberOfSubCorridors; i++) {
                SubCorridor subCorridor = new SubCorridor.SubCorridorBuilder(i).construct();
                maxPowerNeeded += subCorridor.getCurrentTotalPowerConsumption();
                subCorridors.add(subCorridor);
            }

            synchronized (this) {
                this.floorId = Floor.floorCounter++;
            }

            this.maxPowerForFloor = maxPowerNeeded;
        }

        @Override
        public Floor construct() {
            return new Floor(this.floorId, this.mainCorridors, this.subCorridors, this.maxPowerForFloor);
        }
    }
}
