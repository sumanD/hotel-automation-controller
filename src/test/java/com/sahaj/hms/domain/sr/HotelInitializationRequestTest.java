package com.sahaj.hms.domain.sr;

import com.sahaj.hms.util.validator.HotelInitializationRequestValidator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HotelInitializationRequestTest {

    private HotelInitializationRequestValidator hotelInitializationRequestValidator;

    @Before
    public void setup() {
        hotelInitializationRequestValidator = new HotelInitializationRequestValidator();
    }

    private HotelInitializationRequest createHotelInitializationRequest() {
        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(0, 1, 1);
        return hotelInitializationRequest;
    }

    @Test
    public void ifNumberOfFloorsIsZero_numberOfFloorsValidationFails() {
        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(0, 1, 1);

        boolean isValid = hotelInitializationRequestValidator.isValid(hotelInitializationRequest);
        assertEquals(isValid, false);
    }

    @Test
    public void ifNumberOfMainCorridorIsZero_numberOfMainCorridorsPerFloorValidationFails() {
        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 0, 1);

        boolean isValid = hotelInitializationRequestValidator.isValid(hotelInitializationRequest);
        assertEquals(isValid, false);
    }

    @Test
    public void ifNumberOfSubCorridorIsZero_numberOfSubCorridorsPerFloorValidationFails() {
        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 0);

        boolean isValid = hotelInitializationRequestValidator.isValid(hotelInitializationRequest);
        assertEquals(isValid, false);
    }

    @Test
    public void givenRightDetails_thenValidationSuccess() {
        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);

        boolean isValid = hotelInitializationRequestValidator.isValid(hotelInitializationRequest);
        assertEquals(isValid, true);
    }
}