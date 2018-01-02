package com.sahaj.hms.domain.common;

import com.sahaj.hms.domain.enums.CorridorType;

public class Corridor {
    protected Integer corridorId;
    protected CorridorType corridorType;

    protected Corridor(Integer corridorId, CorridorType corridorType) {
        this.corridorId = corridorId;
        this.corridorType = corridorType;
    }

    public Integer getCorridorId() {
        return corridorId;
    }

    public void setCorridorId(Integer corridorId) {
        this.corridorId = corridorId;
    }

    public CorridorType getCorridorType() {
        return corridorType;
    }

    public void setCorridorType(CorridorType corridorType) {
        this.corridorType = corridorType;
    }
}
