package com.sahaj.hms.repository;

import com.sahaj.hms.domain.rule.MainCorridorLightManagementRule;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Encapsulates all the rules applied to the Main Corridor equipments
 */
@Service
public class MainCorridorESMRuleRepository {

    // Light Management Rules for Main Corridor
    private List<MainCorridorLightManagementRule> mainCorridorLightManagementRules;
}
