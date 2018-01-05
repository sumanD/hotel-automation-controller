package com.sahaj.hms.domain.equipment;

import com.sahaj.hms.domain.enums.EquipmentState;
import com.sahaj.hms.domain.enums.EquipmentType;

/**
 * Represent an electrical equipment.
 */
public abstract class Equipment {
    protected EquipmentState equipmentState;
    protected PowerConsumption powerConsumption;
    protected EquipmentType equipmentType;

    protected Equipment(EquipmentState equipmentState, PowerConsumption powerConsumption, EquipmentType equipmentType) {
        this.equipmentState = equipmentState;
        this.powerConsumption = powerConsumption;
        this.equipmentType = equipmentType;
    }

    public EquipmentState getEquipmentState() {
        return equipmentState;
    }

    protected PowerConsumption getPowerConsumption() {
        return powerConsumption;
    }

    protected EquipmentType getEquipmentType() {
        return equipmentType;
    }
}
