package com.sahaj.hms.service.operation.impl;

import com.sahaj.hms.common.HotelFactory;
import com.sahaj.hms.domain.common.Floor;
import com.sahaj.hms.domain.common.Floors;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.common.SubCorridor;
import com.sahaj.hms.domain.sr.HotelInitializationRequest;
import com.sahaj.hms.exception.ValidationException;
import com.sahaj.hms.service.operation.interfaces.FloorOperation;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.*;

import static org.junit.Assert.*;

public class FloorsOperationImplTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

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

    @Test
    public void testSaveEnergyWhenNullFloorsObjectIsProvided_Failure() throws ValidationException {
        String matchString = "saveEnergy() Operation has failed on Floors Object. Reason - Floors object provided is null";

        thrown.expect(ValidationException.class);
        thrown.expectMessage(CoreMatchers.containsString(matchString));

        Floors floors = null;
        floorsOperation.saveEnergy(floors);
    }

    @Test
    public void testRevealCurrentStatus() throws ValidationException {
        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);
        floorsOperation.revealCurrentStatus(hotel.getFloors());

        Mockito.verify(floorOperation).revealCurrentStatus(Matchers.any(Floor.class));
        Mockito.verify(floorOperation, Mockito.times(1)).revealCurrentStatus(Matchers.any(Floor.class));
    }

    @Test
    public void testRevealCurrentStatusWhenNullHotelIsProvided_Failure() throws ValidationException {
        String matchString = "revealCurrentStatus() Operation has failed on Floors Object. Reason - Floors object provided is null";

        thrown.expect(ValidationException.class);
        thrown.expectMessage(CoreMatchers.containsString(matchString));

        Floors floors = null;
        floorsOperation.revealCurrentStatus(floors);
    }

    @Test
    public void testGetSubCorridorById() throws ValidationException {
        HotelInitializationRequest hotelInitializationRequest
                = new HotelInitializationRequest(1, 1, 1);
        Hotel hotel = HotelFactory.construct(hotelInitializationRequest);
        Floors floors = hotel.getFloors();
        Integer floorId = 1;
        Integer subCorridorId = 1;
        SubCorridor subCorridor = floorsOperation.getSubCorridorById(floors, floorId, subCorridorId);
        Assert.assertNull(subCorridor);
    }

    @Test
    public void testGetSubCorridorByIdWhenHotelObjectProvidedIsNull_Failure() throws ValidationException {
        String matchString = "getSubCorridorById() Operation has failed on Floors Object. Reason - Floors object provided is null";

        thrown.expect(ValidationException.class);
        thrown.expectMessage(CoreMatchers.containsString(matchString));

        Floors floors = null;
        Integer floorId = 1;
        Integer subCorridorId = 1;
        floorsOperation.getSubCorridorById(floors, floorId, subCorridorId);
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

        floorsOperation.getSubCorridorById(hotel.getFloors(), floorId, subCorridorId);
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

        floorsOperation.getSubCorridorById(hotel.getFloors(), floorId, subCorridorId);
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

        floorsOperation.getSubCorridorById(hotel.getFloors(), floorId, subCorridorId);
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

        floorsOperation.getSubCorridorById(hotel.getFloors(), floorId, subCorridorId);
    }
}