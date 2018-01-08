package com.sahaj.hms.service.operation.impl;

import com.sahaj.hms.common.HotelFactory;
import com.sahaj.hms.domain.common.Floors;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import com.sahaj.hms.service.operation.interfaces.FloorsOperation;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.junit.Assert.*;

public class HotelOperationImplTest {

    @Mock
    private FloorsOperation floorsOperation;

    @InjectMocks
    private HotelOperationImpl hotelOperation;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }


    @Test
    public void testSaveEnergyWhenFloorsOperationReturnsTrue() {
        Mockito.when(floorsOperation.saveEnergy(Matchers.any(Floors.class))).thenReturn(true);

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);

        assertThat(hotelOperation.saveEnergy(hotel), CoreMatchers.is(true));
        Mockito.verify(floorsOperation).saveEnergy(Matchers.any(Floors.class));
    }

    @Test
    public void testSaveEnergyWhenFloorsOperationReturnsFalse() {
        Mockito.when(floorsOperation.saveEnergy(Matchers.any(Floors.class))).thenReturn(false);

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);

        assertThat(hotelOperation.saveEnergy(hotel), CoreMatchers.is(false));
        Mockito.verify(floorsOperation).saveEnergy(Matchers.any(Floors.class));
    }
}