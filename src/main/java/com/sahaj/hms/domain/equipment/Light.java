package com.sahaj.hms.domain.equipment;

import com.sahaj.hms.common.Builder;
import com.sahaj.hms.domain.enums.EquipmentState;
import com.sahaj.hms.domain.enums.EquipmentType;

/**
 * Represents a Light {@link Light}, an electrical Light equipment.
 * <p>
 * This class is a sub-class of Equipment {@link Equipment} class.
 */
public class Light extends Equipment {
    private static final EquipmentType equipmentType = EquipmentType.LIGHT;

    private Light(EquipmentState equipmentState, PowerConsumption powerConsumption) {
        super(equipmentState, powerConsumption, equipmentType);
    }

    public static class LightBuilder implements Builder<Light> {
        private EquipmentState equipmentState;
        private PowerConsumption powerConsumption;

        public LightBuilder(final EquipmentState equipmentState, final PowerConsumption powerConsumption) {
            this.equipmentState = equipmentState;
            this.powerConsumption = powerConsumption;
        }

        @Override
        public Light construct() {
            return new Light(this.equipmentState, this.powerConsumption);
        }
    }

    public void switchOn() {
        this.equipmentState = EquipmentState.ON;
    }

    public void switchOff(){
        this.equipmentState = EquipmentState.OFF;
    }

    /**
     * This method returns the power consumed by Light at a particular moment
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
