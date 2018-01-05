package com.sahaj.hms.domain.equipment;

import com.sahaj.hms.common.Builder;
import com.sahaj.hms.domain.enums.EquipmentState;
import com.sahaj.hms.domain.enums.EquipmentType;

public class AirConditioner extends Equipment {
    private static final EquipmentType equipmentType = EquipmentType.AIR_CONDITIONER;

    protected AirConditioner(EquipmentState equipmentState, PowerConsumption powerConsumption) {
        super(equipmentState, powerConsumption, equipmentType);
    }

    public static class AirConditionerBuilder implements Builder<AirConditioner> {
        private EquipmentState equipmentState;
        private PowerConsumption powerConsumption;

        public AirConditionerBuilder(EquipmentState equipmentState, PowerConsumption powerConsumption) {
            this.equipmentState = equipmentState;
            this.powerConsumption = powerConsumption;
        }

        public AirConditioner constructAirConditioner() {
            return new AirConditioner(this.equipmentState, this.powerConsumption);
        }

        @Override
        public AirConditioner construct() {
            return new AirConditioner(this.equipmentState, this.powerConsumption);
        }
    }

    public void switchOn() {
        this.equipmentState = EquipmentState.ON;
    }

    public void switchOff() {
        this.equipmentState = EquipmentState.OFF;
    }

    /**
     * This method returns the power consumed by Air - Conditioner at a particular moment
     * @return Power consumed
     */
    public Integer getConsumedPower() {
        if (this.equipmentState == EquipmentState.ON) {
            return this.powerConsumption.getUnitValue();
        }
        else {
            return 0;
        }
    }
}
