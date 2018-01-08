package com.sahaj.hms.service.operation.impl;

import com.sahaj.hms.common.HotelFactory;
import com.sahaj.hms.domain.common.Floors;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.common.SubCorridor;
import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import com.sahaj.hms.exception.ValidationException;
import com.sahaj.hms.service.operation.interfaces.FloorsOperation;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.*;

import static org.junit.Assert.assertThat;

public class HotelOperationImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Mock
    private FloorsOperation floorsOperation;

    @InjectMocks
    private HotelOperationImpl hotelOperation;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testSaveEnergyWhenFloorsOperationReturnsTrue() throws ValidationException {
        Mockito.when(floorsOperation.saveEnergy(Matchers.any(Floors.class))).thenReturn(true);

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);

        assertThat(hotelOperation.saveEnergy(hotel), CoreMatchers.is(true));

        // Verify that the saveEnergy method of FloorsOperation has been called
        Mockito.verify(floorsOperation).saveEnergy(Matchers.any(Floors.class));
        // Verify that the saveEnergy method of FloorsOperation has been called just once
        Mockito.verify(floorsOperation, Mockito.times(1)).saveEnergy(Matchers.any(Floors.class));
    }

    @Test
    public void testSaveEnergyWhenFloorsOperationReturnsFalse() throws ValidationException {
        Mockito.when(floorsOperation.saveEnergy(Matchers.any(Floors.class))).thenReturn(false);

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);

        assertThat(hotelOperation.saveEnergy(hotel), CoreMatchers.is(false));

        Mockito.verify(floorsOperation).saveEnergy(Matchers.any(Floors.class));
        Mockito.verify(floorsOperation, Mockito.times(1)).saveEnergy(Matchers.any(Floors.class));
    }

    @Test
    public void testSaveEnergyWhenNullHotelObjectIsProvided_Failure() throws ValidationException {
        String matchString = "saveEnergy() Operation has failed on Hotel Object. Reason - Hotel object provided is null";

        thrown.expect(ValidationException.class);
        thrown.expectMessage(CoreMatchers.containsString(matchString));

        Hotel hotel = null;
        hotelOperation.saveEnergy(hotel);
    }

    @Test
    public void testRevealCurrentStatus() throws ValidationException {
        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);
        hotelOperation.revealCurrentStatus(hotel);

        Mockito.verify(floorsOperation).revealCurrentStatus(Matchers.any(Floors.class));
        Mockito.verify(floorsOperation, Mockito.times(1)).revealCurrentStatus(Matchers.any(Floors.class));
    }

    @Test
    public void testRevealCurrentStatusWhenNullHotelIsProvided_Failure() throws ValidationException {
        String matchString = "revealCurrentStatus() Operation has failed on Hotel Object. Reason - Hotel object provided is null";

        thrown.expect(ValidationException.class);
        thrown.expectMessage(CoreMatchers.containsString(matchString));

        Hotel hotel = null;
        hotelOperation.revealCurrentStatus(hotel);
    }

    @Test
    public void testGetSubCorridorById() throws ValidationException {
        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);
        Integer floorId = 1;
        Integer subCorridorId = 1;
        SubCorridor subCorridor = new SubCorridor.SubCorridorBuilder(1).construct();

        Mockito.when(floorsOperation.getSubCorridorById(hotel.getFloors(),floorId,subCorridorId)).thenReturn(subCorridor);
        assertThat(hotelOperation.getSubCorridorById(hotel,floorId,subCorridorId), CoreMatchers.isA(SubCorridor.class));
    }

    @Test
    public void testGetSubCorridorByIdWhenHotelObjectProvidedIsNull_Failure() throws ValidationException {
        String matchString = "getSubCorridorById() Operation has failed on Hotel Object. Reason - Hotel object provided is null";

        thrown.expect(ValidationException.class);
        thrown.expectMessage(CoreMatchers.containsString(matchString));

        Hotel hotel = null;
        Integer floorId = 1;
        Integer subCorridorId = 1;
        hotelOperation.getSubCorridorById(hotel,floorId,subCorridorId);
    }

    @Test
    public void testGetSubCorridorByIdWhenFloorIdProvidedIsNull_Failure() throws ValidationException {
        String matchString = "getSubCorridorById() Operation has failed on floorId/SubCorridorId Objects. Reason - floorId/SubCorridorId Objects provided are null/0.";

        thrown.expect(ValidationException.class);
        thrown.expectMessage(CoreMatchers.containsString(matchString));

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);
        Integer floorId = null;
        Integer subCorridorId = 1;

        hotelOperation.getSubCorridorById(hotel,floorId,subCorridorId);
    }

    @Test
    public void testGetSubCorridorByIdWhenFloorIdProvidedIsZero_Failure() throws ValidationException {
        String matchString = "getSubCorridorById() Operation has failed on floorId/SubCorridorId Objects. Reason - floorId/SubCorridorId Objects provided are null/0.";

        thrown.expect(ValidationException.class);
        thrown.expectMessage(CoreMatchers.containsString(matchString));

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);
        Integer floorId = 0;
        Integer subCorridorId = 1;

        hotelOperation.getSubCorridorById(hotel,floorId,subCorridorId);
    }

    @Test
    public void testGetSubCorridorByIdWhenSubCorridorIdProvidedIsNull_Failure() throws ValidationException {
        String matchString = "getSubCorridorById() Operation has failed on floorId/SubCorridorId Objects. Reason - floorId/SubCorridorId Objects provided are null/0.";

        thrown.expect(ValidationException.class);
        thrown.expectMessage(CoreMatchers.containsString(matchString));

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);
        Integer floorId = 1;
        Integer subCorridorId = null;

        hotelOperation.getSubCorridorById(hotel,floorId,subCorridorId);
    }

    @Test
    public void testGetSubCorridorByIdWhenSubCorridorIdProvidedIsZero_Failure() throws ValidationException {
        String matchString = "getSubCorridorById() Operation has failed on floorId/SubCorridorId Objects. Reason - floorId/SubCorridorId Objects provided are null/0.";

        thrown.expect(ValidationException.class);
        thrown.expectMessage(CoreMatchers.containsString(matchString));

        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);
        Integer floorId = 1;
        Integer subCorridorId = 0;

        hotelOperation.getSubCorridorById(hotel,floorId,subCorridorId);
    }
}