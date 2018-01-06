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
}
