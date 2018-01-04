package com.sahaj.hms.domain.common;

import com.sahaj.hms.common.Builder;
import com.sahaj.hms.domain.equipment.PowerConsumption;
import com.sahaj.hms.domain.enums.CorridorType;
import com.sahaj.hms.domain.enums.EquipmentState;
import com.sahaj.hms.domain.enums.SystemOfMeasurement;
import com.sahaj.hms.domain.equipment.AirConditioner;
import com.sahaj.hms.domain.equipment.Light;

public class SubCorridor extends Corridor {
    private static final Integer DEFAULT_SUB_CORRIDOR_LIGHT_POWER_CONSUMPTION_UNIT = 5;
    private static final Integer DEFAULT_SUB_CORRIDOR_AC_POWER_CONSUMPTION_UNIT = 10;

    private Light light;
    private AirConditioner airConditioner;

    protected SubCorridor(Integer corridorId, Light light, AirConditioner airConditioner) {
        super(corridorId, CorridorType.SUB_CORRIDOR);
        this.light = light;
        this.airConditioner = airConditioner;
    }

    public static class SubCorridorBuilder implements Builder<SubCorridor> {
        private Integer corridorId;
        private Light light;
        private AirConditioner airConditioner;

        public SubCorridorBuilder(Integer corridorId) {
            this.corridorId = corridorId;

            // Initializing Light for the Sub Corridor
            PowerConsumption powerConsumption
                    = new PowerConsumption
                    .PowerConsumptionBuilder(DEFAULT_SUB_CORRIDOR_LIGHT_POWER_CONSUMPTION_UNIT, SystemOfMeasurement.UNIT)
                    .construct();
            this.light = new Light.LightBuilder(EquipmentState.OFF, powerConsumption).construct();

            // Initializing Air Conditioner for the Sub Corridor
            PowerConsumption acPowerConsumption
                    = new PowerConsumption
                    .PowerConsumptionBuilder(DEFAULT_SUB_CORRIDOR_AC_POWER_CONSUMPTION_UNIT, SystemOfMeasurement.UNIT)
                    .construct();
            this.airConditioner = new AirConditioner.AirConditionerBuilder(EquipmentState.ON, acPowerConsumption)
                    .constructAirConditioner();

        }

        @Override
        public SubCorridor construct() {
            return new SubCorridor(this.corridorId, this.light, this.airConditioner);
        }
    }

    public Light getLight() {
        return light;
    }

    public AirConditioner getAirConditioner() {
        return airConditioner;
    }
}


