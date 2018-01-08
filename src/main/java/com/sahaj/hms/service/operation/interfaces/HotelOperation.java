package com.sahaj.hms.service.operation.interfaces;

import com.sahaj.hms.common.Operation;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.common.SubCorridor;

/**
 * Service to operate on Hotel Equipments
 */
public interface HotelOperation extends Operation<Hotel> {
    /**
     * Returns the {@link SubCorridor} of a {@link Hotel}
     *
     * @param hotel         The {@link Hotel} having the {@link SubCorridor}
     * @param floorId       The Id of the {@link com.sahaj.hms.domain.common.Floor} having the {@link SubCorridor}
     * @param subCorridorId The Id of the {@link SubCorridor}
     * @return Matched {@link SubCorridor}
     */
    SubCorridor getSubCorridorById(Hotel hotel, Integer floorId, Integer subCorridorId);
}
