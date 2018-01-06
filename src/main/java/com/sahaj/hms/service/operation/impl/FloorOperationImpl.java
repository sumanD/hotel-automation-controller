package com.sahaj.hms.service.operation.impl;

import com.sahaj.hms.domain.common.Floor;
import com.sahaj.hms.domain.common.MainCorridor;
import com.sahaj.hms.domain.common.SubCorridor;
import com.sahaj.hms.domain.equipment.AirConditioner;
import com.sahaj.hms.domain.equipment.Light;
import com.sahaj.hms.service.operation.interfaces.FloorOperation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FloorOperationImpl implements FloorOperation {

    /**
     * This method saves energy by switching Off the Equipments ({@link Light} & {@link AirConditioner})
     * if required depending on the energy rule
     *
     * @param floor
     */
    @Override
    public void saveEnergy(final Floor floor) {
        keepTogglingAcsUntilEnergyRuleViolates(floor);
    }

    /**
     * @param floor Floor Object whose Equipment state needs to be revealed
     */
    @Override
    public void revealCurrentStatus(final Floor floor) {
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

    /**
     * Total Power consumption at a particular moment
     *
     * @param floor
     * @return
     */
    private Integer getRealTimeTotalPowerConsumption(Floor floor) {
        List<MainCorridor> mainCorridors = floor.getMainCorridors();

        Integer totalFloorPowerConsumption = 0;

        for (MainCorridor mainCorridor : mainCorridors) {
            totalFloorPowerConsumption += mainCorridor.getTotalPowerConsumption();
        }

        List<SubCorridor> subCorridors = floor.getSubCorridors();
        for (SubCorridor subCorridor : subCorridors) {
            totalFloorPowerConsumption += subCorridor.getCurrentTotalPowerConsumption();
        }

        return totalFloorPowerConsumption;
    }

    /**
     * Keep on switching off ACs of Sub-Corridor until the Floor Energy Consumption limit is
     * not satisfied
     *
     * @param floor
     */
    private void keepTogglingAcsUntilEnergyRuleViolates(final Floor floor) {
        int currentPowerConsumptionPerFloor = getRealTimeTotalPowerConsumption(floor).intValue();
        int maxPowerConsumptionLimit = floor.getMaxAllowedPowerConsumptionLimitPerFloor();

        if (currentPowerConsumptionPerFloor > maxPowerConsumptionLimit) {
            List<SubCorridor> subCorridorList = floor.getSubCorridors();
            for (SubCorridor subCorridor : subCorridorList) {
                subCorridor.getAirConditioner().switchOff();
                currentPowerConsumptionPerFloor = getRealTimeTotalPowerConsumption(floor).intValue();

                if (currentPowerConsumptionPerFloor <= maxPowerConsumptionLimit) {
                    break;
                }
            }
        } else {
            List<SubCorridor> subCorridorList = floor.getSubCorridors();
            for (SubCorridor subCorridor : subCorridorList) {
                subCorridor.getAirConditioner().switchOn();
                currentPowerConsumptionPerFloor = getRealTimeTotalPowerConsumption(floor).intValue();

                if (currentPowerConsumptionPerFloor == maxPowerConsumptionLimit) {
                    break;
                }
            }
        }
    }
}
