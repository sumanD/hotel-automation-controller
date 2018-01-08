package com.sahaj.hms.domain.sr;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;

/**
 * First Request for Setting up the Hotel Infrastructure in this system
 */
public class HotelInitializationRequest {
    @Digits(integer = 1, fraction = 0)
    @Min(1)
    private Integer numberOfFloors;

    @Digits(integer = 1, fraction = 0)
    @Min(1)
    private Integer numberOfMainCorridorsPerFloor;

    @Digits(integer = 1, fraction = 0)
    @Min(1)
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
