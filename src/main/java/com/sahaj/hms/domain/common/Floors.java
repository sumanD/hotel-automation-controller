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

    /**
     * Prints Equipment Status of hotel's Floors
     */
    public void printState() {
        for (int i = 0; i < floors.size(); i++) {
            System.out.println("Floor " + (i + 1));

            Floor floor = floors.get(i);
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
