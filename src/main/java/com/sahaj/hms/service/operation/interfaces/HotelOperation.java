package com.sahaj.hms.service.operation.interfaces;

import com.sahaj.hms.common.Operation;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.common.SubCorridor;

public interface HotelOperation extends Operation<Hotel> {
    SubCorridor getSubCorridorById(Hotel hotel, Integer floorId, Integer subCorridorId);
}
