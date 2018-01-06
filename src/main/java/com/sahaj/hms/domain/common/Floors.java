package com.sahaj.hms.domain.common;

import com.sahaj.hms.common.Builder;
import com.sahaj.hms.domain.equipment.AirConditioner;
import com.sahaj.hms.domain.equipment.Light;

import java.util.List;

/**
 * The {@code Floors} class wraps a list of {@Link Floor} in an Object.
 * This class provides several methods to operate on the {@Link Floor}
 */

public class Floors {
    private List<Floor> floors;

    private Floors(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public static class FloorsBuilder implements Builder<Floors> {
        private List<Floor> floors;

        public FloorsBuilder(List<Floor> floors) {
            this.floors = floors;
        }

        @Override
        public Floors construct() {
            return new Floors(this.floors);
        }
    }
}
