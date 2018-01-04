package com.sahaj.hms.domain.sr;

import com.sahaj.hms.common.Builder;
import com.sahaj.hms.domain.common.Corridor;
import com.sahaj.hms.domain.common.Floor;
import com.sahaj.hms.domain.common.SubCorridor;
import com.sahaj.hms.domain.enums.MovementStatus;

public class SensorInputRequest {
    private MovementStatus movementStatus;
    private Floor onWhichFloor;
    private SubCorridor onWhichSubCorridor;

    private SensorInputRequest(final MovementStatus movementStatus,
                               final Floor floorNumber,
                               final SubCorridor subCorridor) {
        this.movementStatus = movementStatus;
        this.onWhichFloor = floorNumber;
        this.onWhichSubCorridor = subCorridor;
    }

    // Builder to generate a Sensor Input Request
    public static class SensorInputRequestBuilder implements Builder<SensorInputRequest>{
        private MovementStatus movementStatus;
        private Floor onWhichFloor;
        private SubCorridor onWhichSubCorridor;

        public SensorInputRequestBuilder(final MovementStatus movementStatus,
                                  final Floor onWhichFloor,
                                  final SubCorridor onWhichSubCorridor) {
            this.movementStatus = movementStatus;
            this.onWhichFloor = onWhichFloor;
            this.onWhichSubCorridor = onWhichSubCorridor;
        }

        @Override
        public SensorInputRequest construct() {
            return new SensorInputRequest(movementStatus,onWhichFloor,onWhichSubCorridor);
        }
    }

    public MovementStatus getMovementStatus() {
        return movementStatus;
    }

    public Floor getFloorNumber() {
        return onWhichFloor;
    }

    public Corridor getCorridor() {
        return onWhichSubCorridor;
    }
}
