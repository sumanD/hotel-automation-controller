package com.sahaj.hms.util;

import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import com.sahaj.hms.domain.sr.SensorInputRequest;
import com.sahaj.hms.exception.InvalidHotelInitRequestException;
import com.sahaj.hms.util.validator.HotelInitializationRequestValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Validator;

/**
 * Utility Class has exposed method to calculate max allowed power consumption limit for a hotel.
 */
@Service
public final class PowerConsumptionCalculator {

    @Autowired
    private HotelInitializationRequestValidator validator;

    /**
     * This method calculates the calculate max allowed power consumption limit for a hotel
     *
     * @param hotelInitializationRequest Initial Request having number of {@link com.sahaj.hms.domain.common.MainCorridor}
     *                                   and number of {@link com.sahaj.hms.domain.common.SubCorridor} provided
     *                                   during system initialization
     * @return Integer value representing the total allowed power consumption limit
     */
    public Integer calculateMaxAllowedPowerLimit(final HotelInitializationRequest hotelInitializationRequest)
            throws InvalidHotelInitRequestException {
        boolean isValidRequest = validator.isValid(hotelInitializationRequest);
        if (!isValidRequest) {
            String errorMessage = "HotelInitializationRequest is invalid. " +
                    "HotelInitializationRequest = " + hotelInitializationRequest;
            throw new InvalidHotelInitRequestException(errorMessage);
        }

        Integer totalAllowedPowerConsumptionLimit = 0;
        if (hotelInitializationRequest != null) {
            Integer numberOfMainCorridorsPerFloor = hotelInitializationRequest.getNumberOfMainCorridorsPerFloor();
            Integer numberOfSubCorridorsPerFloor = hotelInitializationRequest.getNumberOfSubCorridorsPerFloor();

            totalAllowedPowerConsumptionLimit = (numberOfMainCorridorsPerFloor * 15)
                    + (numberOfSubCorridorsPerFloor * 10);
        }
        return totalAllowedPowerConsumptionLimit;
    }
}
