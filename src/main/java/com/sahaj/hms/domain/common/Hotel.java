package com.sahaj.hms.domain.common;

/**
 * Represents a Hotel entity
 * <p>
 * A hotel has the following dependent entities -
 * -> A list of Floors {@link Floors}
 */

public class Hotel {
    private Floors floors;

    public Hotel(Floors floors) {
        this.floors = floors;
    }

    public Floors getFloors() {
        return floors;
    }

    /**
     * Prints equipment Status of a Hotel
     */
    public void printState() {
        floors.printState();
    }

    public Floor getFloorById(Integer floorId) {
        return floors.getFloorById(floorId);
    }

    public SubCorridor getSubCorridorById(Integer floorId, Integer subCorridorId) {
        return floors.getSubCorridorById(floorId, subCorridorId);
    }

    public void saveEnergy(Integer floorId, Integer subCorridorId) {
        floors.saveEnergy(floorId, subCorridorId);
    }
}
