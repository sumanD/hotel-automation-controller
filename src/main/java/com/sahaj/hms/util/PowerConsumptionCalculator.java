package com.sahaj.hms.util;

import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import com.sahaj.hms.domain.sr.SensorInputRequest;

/**
 * Utility Class has exposed method to calculate max allowed power consumption limit for a hotel.
 */
public final class PowerConsumptionCalculator {

    /**
     * This method calculates the calculate max allowed power consumption limit for a hotel
     * @param hotelInitializationRequest
     *                                      Initial Request having number of {@link com.sahaj.hms.domain.common.MainCorridor}
     *                                      and number of {@link com.sahaj.hms.domain.common.SubCorridor} provided
     *                                      during system initialization
     * @return Integer value representing the total allowed power consumption limit
     */
    public static Integer calculateMaxAllowedPowerLimit(final HotelInitializationRequest hotelInitializationRequest) {
        Integer totalAllowedPowerConsumptionLimit = 0;
        if(hotelInitializationRequest != null) {
            Integer numberOfMainCorridorsPerFloor = hotelInitializationRequest.getNumberOfMainCorridorsPerFloor();
            Integer numberOfSubCorridorsPerFloor = hotelInitializationRequest.getNumberOfSubCorridorsPerFloor();

            totalAllowedPowerConsumptionLimit = (numberOfMainCorridorsPerFloor * 15)
                    + (numberOfSubCorridorsPerFloor * 10);
        }
        return totalAllowedPowerConsumptionLimit;
    }
}
