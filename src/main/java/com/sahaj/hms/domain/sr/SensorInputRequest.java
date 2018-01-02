package com.sahaj.hms.domain.sr;

import com.sahaj.hms.common.Builder;
import com.sahaj.hms.domain.common.Corridor;
import com.sahaj.hms.domain.common.Floor;
import com.sahaj.hms.domain.enums.MovementStatus;

public class SensorInputRequest {
    private MovementStatus movementStatus;
    private Floor floorNumber;
    private Corridor corridor;

    private SensorInputRequest(final MovementStatus movementStatus,
                               final Floor floorNumber,
                               final Corridor corridor) {
        this.movementStatus = movementStatus;
        this.floorNumber = floorNumber;
        this.corridor = corridor;
    }

    // Builder to generate a Sensor Input Request
    public static class SensorInputRequestBuilder implements Builder<SensorInputRequest>{
        private MovementStatus movementStatus;
        private Floor floorNumber;
        private Corridor corridor;

        public SensorInputRequestBuilder(final MovementStatus movementStatus,
                                  final Floor floorNumber,
                                  final Corridor corridor) {
            this.movementStatus = movementStatus;
            this.floorNumber = floorNumber;
            this.corridor = corridor;
        }

        @Override
        public SensorInputRequest construct() {
            return new SensorInputRequest(movementStatus,floorNumber,corridor);
        }
    }

    public MovementStatus getMovementStatus() {
        return movementStatus;
    }

    public Floor getFloorNumber() {
        return floorNumber;
    }

    public Corridor getCorridor() {
        return corridor;
    }
}
