package com.sahaj.hms.domain.common;

import com.sahaj.hms.common.Builder;
import com.sahaj.hms.domain.equipment.AirConditioner;
import com.sahaj.hms.domain.equipment.Light;

import java.util.List;

/**
 * The {@code Floors} class wraps a list of {@Link Floor} in an Object.
 * This class provides several methods to operate on the {@Link Floor}
 */

public class Floors {
    private List<Floor> floors;

    private Floors(List<Floor> floors) {
        this.floors = floors;
    }

    public static class FloorsBuilder implements Builder<Floors> {
        private List<Floor> floors;

        public FloorsBuilder(List<Floor> floors) {
            this.floors = floors;
        }

        @Override
        public Floors construct() {
            return new Floors(this.floors);
        }
    }

    public Floor getFloorById(Integer floorId) {
        Floor floorToBeSearched = null;
        for (Floor floor : floors) {
            if (floor.getFloorId().equals(floorId)) {
                floorToBeSearched = floor;
            }
        }
        return floorToBeSearched;
    }

    public Integer getFloorPowerConsumption(Integer floorId) {
        Floor floor = getFloorById(floorId);
        return floor.getRealTimeTotalPowerConsumption();
    }

    public SubCorridor getSubCorridorById(Integer floorId, Integer subCorridorId) {
        Floor floor = getFloorById(floorId);
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

    /**
     * This method saves energy by switching Off the Equipments ({@link Light} & {@link AirConditioner})
     * if required depending on the energy rule
     *
     * @param floorId
     *
     */
    public void saveEnergy(Integer floorId, Integer subCorridorId) {
        for (Floor floor : floors) {
            Integer powerConsumptionPerFloor = floor.getRealTimeTotalPowerConsumption();
            System.out.println("Current_Power_Consumption[1] = "+ powerConsumptionPerFloor);
            System.out.println("MAX_ALLOWED [1] = " + floor.getTotalConsumedPowerPerFloor());

            if(powerConsumptionPerFloor > floor.getTotalConsumedPowerPerFloor()){

                List<SubCorridor> subCorridorList = floor.getSubCorridors();
                for (SubCorridor subCorridor : subCorridorList) {

                    System.out.println("Current_Power_Consumption [2] = "+ powerConsumptionPerFloor);
                    System.out.println("MAX_ALLOWED [2] = " + floor.getTotalConsumedPowerPerFloor());

                    if(powerConsumptionPerFloor > floor.getTotalConsumedPowerPerFloor()) {
                        System.out.println("SUB_CORRIDOR_POWER [3]= " + subCorridor.getAirConditioner().getConsumedPower());
                        powerConsumptionPerFloor -= subCorridor.getAirConditioner().getConsumedPower();
                        System.out.println("AFTER CHANGE = " + powerConsumptionPerFloor);
                        switchOffSubCorridorsAcs(floor);
                    }
                    else {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Switch Off Sub Corridor's AC
     *
     * @param floor Floor Object whose Sub Corridor's Equipment needs to be switched off
     */
    private void switchOffSubCorridorsAcs(Floor floor) {
        List<SubCorridor> subCorridorList = floor.getSubCorridors();
        for (SubCorridor subCorridor : subCorridorList) {
            subCorridor.getAirConditioner().switchOff();
        }
    }

    /**
     * Prints Equipment Status of hotel's Floors
     */
    public void printState() {
        for (int i = 0; i < floors.size(); i++) {
            Floor floor = floors.get(i);

            System.out.println("Floor " + floor.getFloorId());

            List<MainCorridor> mainCorridors = floor.getMainCorridors();

            for (int j = 0; j < mainCorridors.size(); j++) {
                System.out.println("\t Main corridor " + (j + 1));
                MainCorridor mainCorridor = mainCorridors.get(j);

                Light light = mainCorridor.getLight();
                System.out.println("\t\t Light " + (j + 1) + " : " + light.getEquipmentState());

                AirConditioner airConditioner = mainCorridor.getAirConditioner();
                System.out.println("\t\t AC : " + airConditioner.getEquipmentState());
            }

            List<SubCorridor> subCorridors = floor.getSubCorridors();
            for (int k = 0; k < subCorridors.size(); k++) {
                System.out.println("\t Sub corridor " + (k + 1));
                SubCorridor subCorridor = subCorridors.get(k);

                Light light = subCorridor.getLight();
                System.out.println("\t\t Light " + (k + 1) + " : " + light.getEquipmentState());

                AirConditioner airConditioner = subCorridor.getAirConditioner();
                System.out.println("\t\t AC : " + airConditioner.getEquipmentState());
            }
        }
    }
}
