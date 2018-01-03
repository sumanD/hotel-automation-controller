package com.sahaj.hms.domain.rule;


import com.sahaj.hms.common.Builder;
import com.sahaj.hms.common.Factory;
import com.sahaj.hms.common.TimeSlotFactory;
import com.sahaj.hms.domain.ts.DayTimeSlot;
import com.sahaj.hms.domain.ts.NightTimeSlot;
import com.sahaj.hms.domain.ts.TimeSlot;
import com.sahaj.hms.domain.enums.EquipmentState;
import com.sahaj.hms.domain.enums.EquipmentType;
import com.sahaj.hms.domain.enums.MovementStatus;
import com.sahaj.hms.domain.enums.TimeSlotType;

/**
 * Light Management Rule fo Main Corridor
 */
public class MainCorridorLightManagementRule {

    private final static Factory<TimeSlot,TimeSlotType> timeSlotFactory = new TimeSlotFactory();

    private EquipmentStateManagementRule equipmentStateManagementRule;

    private MainCorridorLightManagementRule(EquipmentStateManagementRule equipmentStateManagementRule) {
        this.equipmentStateManagementRule = equipmentStateManagementRule;
    }

    public static class MainCorridorLightManagementRuleBuilder implements Builder<MainCorridorLightManagementRule> {
        private EquipmentStateManagementRule equipmentStateManagementRule;

        /**
         * Constructs a {@link MainCorridorLightManagementRuleBuilder}
         *
         * @param equipmentState Equipment Status associated with the Rule
         * @param timeSlotType   Time Slot associated with the Equipment and Rule
         * @param movementStatus Human Movement status on Main Corridor
         */
        public MainCorridorLightManagementRuleBuilder(final EquipmentState equipmentState,
                                                      final TimeSlotType timeSlotType,
                                                      final MovementStatus movementStatus) {

            TimeSlot timeSlot = timeSlotFactory.getObject(timeSlotType);
            this.equipmentStateManagementRule = new EquipmentStateManagementRule
                    .EquipmentStateManagementRuleBuilder(EquipmentType.LIGHT, equipmentState, timeSlot, movementStatus).construct();
        }

        @Override
        public MainCorridorLightManagementRule construct() {
            return new MainCorridorLightManagementRule(this.equipmentStateManagementRule);
        }
    }
}
