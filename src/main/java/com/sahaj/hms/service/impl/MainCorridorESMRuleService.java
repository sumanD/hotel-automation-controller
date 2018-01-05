package com.sahaj.hms.service.impl;


import com.sahaj.hms.repository.MainCorridorESMRuleRepository;
import com.sahaj.hms.service.EquipmentStateManagementRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service to Validate Equipment status for Main Corridor against the rules associated with Main Corridor equipments.
 */

@Service
public class MainCorridorESMRuleService implements EquipmentStateManagementRuleService {

    @Autowired
    private MainCorridorESMRuleRepository mainCorridorESMRuleRepository;

    @Override
    public boolean isValidRule() {
        return false;
    }
}
