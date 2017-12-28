package com.sahaj.hms.domain;

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

    public static class SensorInputRequestBuilder {
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

        public SensorInputRequest constructSensorInputRequest() {
            return new SensorInputRequest(movementStatus,floorNumber,corridor);
        }
    }

    public MovementStatus getMovementStatus() {
        return movementStatus;
    }

    public void setMovementStatus(MovementStatus movementStatus) {
        this.movementStatus = movementStatus;
    }

    public Floor getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(Floor floorNumber) {
        this.floorNumber = floorNumber;
    }

    public Corridor getCorridor() {
        return corridor;
    }

    public void setCorridor(Corridor corridor) {
        this.corridor = corridor;
    }
}
