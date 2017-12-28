package com.sahaj.hms.domain;

import com.sahaj.hms.domain.enums.CorridorType;

public class SubCorridor extends Corridor{
    public SubCorridor(Integer corridorId) {
        super(corridorId, CorridorType.SUB_CORRIDOR);
    }
}
