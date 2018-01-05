package com.sahaj.hms.domain.equipment;

import com.sahaj.hms.common.Builder;
import com.sahaj.hms.domain.enums.SystemOfMeasurement;

public class PowerConsumption {
    private Integer unitValue;
    private SystemOfMeasurement systemOfMeasurement;

    private PowerConsumption(Integer unitValue, SystemOfMeasurement systemOfMeasurement) {
        this.unitValue = unitValue;
        this.systemOfMeasurement = systemOfMeasurement;
    }

    public static class PowerConsumptionBuilder implements Builder<PowerConsumption>{
        private Integer unitValue;
        private SystemOfMeasurement systemOfMeasurement;

        public PowerConsumptionBuilder(final Integer unitValue, final SystemOfMeasurement systemOfMeasurement) {
            this.unitValue = unitValue;
            this.systemOfMeasurement = systemOfMeasurement;
        }

        @Override
        public PowerConsumption construct() {
            return new PowerConsumption(this.unitValue,this.systemOfMeasurement);
        }
    }

    Integer getUnitValue() {
        return unitValue;
    }
}
