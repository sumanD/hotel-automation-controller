package com.sahaj.hms.domain.common;

import com.sahaj.hms.common.Builder;
import com.sahaj.hms.domain.equipment.PowerConsumption;
import com.sahaj.hms.domain.enums.CorridorType;
import com.sahaj.hms.domain.enums.EquipmentState;
import com.sahaj.hms.domain.enums.SystemOfMeasurement;
import com.sahaj.hms.domain.equipment.AirConditioner;
import com.sahaj.hms.domain.equipment.Light;

/**
 * Represents Main Corridor {@link MainCorridor} of a hotel floor.
 * <p>
 * {@link MainCorridor} has a Single {@link Light} in it.
 * <p>
 * This class provides methods to operate on {@link MainCorridor}
 */
public class MainCorridor extends Corridor {

    private static final Integer DEFAULT_MAIN_CORRIDOR_LIGHT_POWER_CONSUMPTION_UNIT = 5;
    private static final Integer DEFAULT_MAIN_CORRIDOR_AC_POWER_CONSUMPTION_UNIT = 10;

    private Light light;
    private AirConditioner airConditioner;

    public MainCorridor(Integer corridorId, Light light, AirConditioner airConditioner) {
        super(corridorId, CorridorType.MAIN_CORRIDOR);
        this.light = light;
        this.airConditioner = airConditioner;
    }

    public static class MainCorridorBuilder implements Builder<MainCorridor> {
        private Integer corridorId;
        private Light light;
        private AirConditioner airConditioner;


        public MainCorridorBuilder(Integer corridorId) {
            this.corridorId = corridorId;

            // Initializing light for the Main Corridor
            PowerConsumption lightPowerConsumption
                    = new PowerConsumption
                    .PowerConsumptionBuilder(DEFAULT_MAIN_CORRIDOR_LIGHT_POWER_CONSUMPTION_UNIT, SystemOfMeasurement.UNIT)
                    .construct();
            this.light = new Light.LightBuilder(EquipmentState.ON, lightPowerConsumption).construct();

            // Initializing Air Conditioner for the Main Corridor
            PowerConsumption acPowerConsumption
                    = new PowerConsumption
                    .PowerConsumptionBuilder(DEFAULT_MAIN_CORRIDOR_AC_POWER_CONSUMPTION_UNIT, SystemOfMeasurement.UNIT)
                    .construct();
            this.airConditioner = new AirConditioner.AirConditionerBuilder(EquipmentState.ON, acPowerConsumption)
                    .constructAirConditioner();
        }

        @Override
        public MainCorridor construct() {
            return new MainCorridor(this.corridorId, this.light, this.airConditioner);
        }
    }

    public Light getLight() {
        return light;
    }

    public AirConditioner getAirConditioner() {
        return airConditioner;
    }

    @Override
    public String toString() {
        return "MainCorridor{" +
                "light=" + light +
                ", airConditioner=" + airConditioner +
                ", corridorId=" + corridorId +
                ", corridorType=" + corridorType +
                '}';
    }
}
