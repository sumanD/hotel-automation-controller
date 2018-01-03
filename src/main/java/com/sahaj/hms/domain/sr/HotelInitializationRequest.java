package com.sahaj.hms.domain.sr;

/**
 * First Request for Setting up the Hotel Infrastructure in this system
 */
public class HotelInitializationRequest {
    private Integer numberOfFloors;
    private Integer numberOfMainCorridorsPerFloor;
    private Integer numberOfSubCorridorsPerFloor;

    public HotelInitializationRequest(Integer numberOfFloors,
                                      Integer numberOfMainCorridorsPerFloor,
                                      Integer numberOfSubCorridorsPerFloor) {
        this.numberOfFloors = numberOfFloors;
        this.numberOfMainCorridorsPerFloor = numberOfMainCorridorsPerFloor;
        this.numberOfSubCorridorsPerFloor = numberOfSubCorridorsPerFloor;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public Integer getNumberOfMainCorridorsPerFloor() {
        return numberOfMainCorridorsPerFloor;
    }

    public Integer getNumberOfSubCorridorsPerFloor() {
        return numberOfSubCorridorsPerFloor;
    }

    @Override
    public String toString() {
        return "HotelInitializationRequest{" +
                "numberOfFloors=" + numberOfFloors +
                ", numberOfMainCorridorsPerFloor=" + numberOfMainCorridorsPerFloor +
                ", numberOfSubCorridorsPerFloor=" + numberOfSubCorridorsPerFloor +
                '}';
    }
}
