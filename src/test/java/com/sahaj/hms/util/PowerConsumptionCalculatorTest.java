package com.sahaj.hms.util;

import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import com.sahaj.hms.exception.InvalidHotelInitRequestException;
import com.sahaj.hms.service.config.AppConfig;
import com.sahaj.hms.util.validator.HotelInitializationRequestValidator;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {AppConfig.class})
public class PowerConsumptionCalculatorTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    public HotelInitializationRequestValidator validator;

    @InjectMocks
    public PowerConsumptionCalculator calculator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    /**
     * Tests the Happy Path Flow and calculates the Maximum Power Consumption Limit Per Floor
     */
    @Test
    public void testCalculateMaxAllowedPowerLimit() {
        Integer numberOfFloors = 1;
        Integer numberOfMainCorridorsPerFloor = 1;
        Integer numberOfSubCorridorsPerFloor = 1;

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(numberOfFloors, numberOfMainCorridorsPerFloor, numberOfSubCorridorsPerFloor);

        Mockito.when(validator.isValid(hotelInitializationRequest)).thenReturn(true);

        Integer totalPowerConsumption = null;
        try {
            totalPowerConsumption = calculator.calculateMaxAllowedPowerLimit(hotelInitializationRequest);
        } catch (InvalidHotelInitRequestException e) {
            e.printStackTrace();
            Assert.assertFalse(true);
        }
        Assert.assertEquals(totalPowerConsumption.intValue(), 25);
    }

    /**
     * Test the Happy Path Flow and calculates the Maximum Power Consumption Limit Per Floor with more number of
     * Main Corridor and Sub Corridor
     */
    @Test
    public void testCalculateMaxAllowedPowerLimitWithHigherFloorNumbers() {
        Integer numberOfFloors = 1;
        Integer numberOfMainCorridorsPerFloor = 10;
        Integer numberOfSubCorridorsPerFloor = 10;

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(numberOfFloors, numberOfMainCorridorsPerFloor, numberOfSubCorridorsPerFloor);

        Mockito.when(validator.isValid(hotelInitializationRequest)).thenReturn(true);

        Integer totalPowerConsumption = null;
        try {
            totalPowerConsumption = calculator.calculateMaxAllowedPowerLimit(hotelInitializationRequest);
        } catch (InvalidHotelInitRequestException e) {
            e.printStackTrace();
            Assert.assertFalse(true);
        }
        Assert.assertEquals(totalPowerConsumption.intValue(), 250);
    }

    /**
     * Test for InvalidHotelInitRequestException Exception
     *
     * @throws InvalidHotelInitRequestException
     */
    @Test
    public void testCalculateMaxAllowedPowerLimitWithNegativeValues() throws InvalidHotelInitRequestException {

        thrown.expect(InvalidHotelInitRequestException.class);
        thrown.expectMessage(CoreMatchers.containsString("HotelInitializationRequest is invalid. HotelInitializationRequest = "));

        Integer numberOfFloors = 0;
        Integer numberOfMainCorridorsPerFloor = 0;
        Integer numberOfSubCorridorsPerFloor = 0;

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(numberOfFloors, numberOfMainCorridorsPerFloor, numberOfSubCorridorsPerFloor);

        Mockito.when(validator.isValid(hotelInitializationRequest)).thenReturn(false);

        calculator.calculateMaxAllowedPowerLimit(hotelInitializationRequest);
    }
}