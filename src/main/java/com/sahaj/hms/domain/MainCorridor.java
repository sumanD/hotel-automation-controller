package com.sahaj.hms.domain;

import com.sahaj.hms.domain.enums.CorridorType;

public class MainCorridor extends Corridor {
    public MainCorridor(Integer corridorNumber) {
        super(corridorNumber, CorridorType.MAIN_CORRIDOR);
    }
}
