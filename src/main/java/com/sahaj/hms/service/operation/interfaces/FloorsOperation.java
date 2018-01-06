package com.sahaj.hms.service.operation.interfaces;

import com.sahaj.hms.common.Operation;
import com.sahaj.hms.domain.common.Floor;
import com.sahaj.hms.domain.common.Floors;
import com.sahaj.hms.domain.common.Hotel;
import com.sahaj.hms.domain.common.SubCorridor;

public interface FloorsOperation extends Operation<Floors> {
    SubCorridor getSubCorridorById(Floors floors, Integer floorId, Integer subCorridorId);
    Floor getFloorById(Floors floors, Integer floorId);
}
