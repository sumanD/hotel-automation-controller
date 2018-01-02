package com.sahaj.hms.domain.rule;

import com.sahaj.hms.common.Builder;
import com.sahaj.hms.domain.ts.TimeSlot;
import com.sahaj.hms.domain.enums.EquipmentState;
import com.sahaj.hms.domain.enums.EquipmentType;
import com.sahaj.hms.domain.enums.MovementStatus;

/**
 * This class represent a Rule for managing different equipment in a hotel.
 * <p>
 * e.g., All Lights of Main Corridor will be switched on between 6 PM - 6 AM
 */
public class EquipmentStateManagementRule {
    private EquipmentType equipmentType;
    private EquipmentState equipmentState;
    private TimeSlot timeSlot;
    private MovementStatus movementStatus;

    private EquipmentStateManagementRule(EquipmentType equipmentType,
                                         EquipmentState equipmentState,
                                         TimeSlot timeSlot,
                                         MovementStatus movementStatus) {
        this.equipmentType = equipmentType;
        this.equipmentState = equipmentState;
        this.timeSlot = timeSlot;
        this.movementStatus = movementStatus;
    }

    public static class EquipmentStateManagementRuleBuilder implements Builder<EquipmentStateManagementRule> {

        private EquipmentType equipmentType;
        private EquipmentState equipmentState;
        private TimeSlot timeSlot;
        private MovementStatus movementStatus;

        public EquipmentStateManagementRuleBuilder(final EquipmentType equipmentType,
                                                   final EquipmentState equipmentState,
                                                   final TimeSlot timeSlot,
                                                   final MovementStatus movementStatus) {
            this.equipmentType = equipmentType;
            this.equipmentState = equipmentState;
            this.timeSlot = timeSlot;
            this.movementStatus = movementStatus;
        }

        @Override
        public EquipmentStateManagementRule construct() {
            return new EquipmentStateManagementRule(this.equipmentType,
                    this.equipmentState, this.timeSlot, this.movementStatus);
        }
    }
}
