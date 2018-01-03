package com.sahaj.hms.repository;

import com.sahaj.hms.domain.enums.EquipmentState;
import com.sahaj.hms.domain.enums.MovementStatus;
import com.sahaj.hms.domain.enums.TimeSlotType;
import com.sahaj.hms.domain.rule.MainCorridorLightManagementRule;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Encapsulates all the rules applied to the Main Corridor equipments
 * Main Corridor Equipment Status Management Rule Repository
 */
@Service
public final class MainCorridorESMRuleRepository {

    // Light Management Rules for Main Corridor
    private static List<MainCorridorLightManagementRule> mainCorridorLightManagementRules;

    static {
        MainCorridorLightManagementRule lightManagementRule = new MainCorridorLightManagementRule
                .MainCorridorLightManagementRuleBuilder(
                EquipmentState.ON,
                TimeSlotType.NIGHT_TIME_SLOT,
                MovementStatus.DEFAULT).construct();

        mainCorridorLightManagementRules = new ArrayList<>();
        mainCorridorLightManagementRules.add(lightManagementRule);
    }
}
