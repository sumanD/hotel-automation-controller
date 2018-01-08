package com.sahaj.hms.service.operation.impl;

import com.sahaj.hms.common.HotelFactory;
import com.sahaj.hms.domain.common.Floor;
import com.sahaj.hms.domain.common.Floors;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import com.sahaj.hms.exception.ValidationException;
import com.sahaj.hms.service.operation.interfaces.FloorOperation;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.*;

public class FloorsOperationImplTest {

    @Mock
    private FloorOperation floorOperation;

    @InjectMocks
    private FloorsOperationImpl floorsOperation;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveEnergyWhenFloorOperationReturnsTrue() throws ValidationException {
        Mockito.when(floorOperation.saveEnergy(Matchers.any(Floor.class))).thenReturn(true);

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);

        // Verify that the save method has been invoked
        assertThat(floorsOperation.saveEnergy(hotel.getFloors()), CoreMatchers.is(true));
        Mockito.verify(floorOperation).saveEnergy(Matchers.any(Floor.class));
    }

    @Test
    public void testSaveEnergyWhenFloorOperationReturnsFalse() throws ValidationException {
        Mockito.when(floorOperation.saveEnergy(Matchers.any(Floor.class))).thenReturn(false);

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);

        // Verify that the save method has been invoked
        assertThat(floorsOperation.saveEnergy(hotel.getFloors()), CoreMatchers.is(false));
        Mockito.verify(floorOperation).saveEnergy(Matchers.any(Floor.class));
    }
}