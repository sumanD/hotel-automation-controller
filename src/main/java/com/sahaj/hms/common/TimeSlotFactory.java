package com.sahaj.hms.common;

import com.sahaj.hms.domain.enums.TimeSlotType;
import com.sahaj.hms.domain.ts.DayTimeSlot;
import com.sahaj.hms.domain.ts.NightTimeSlot;
import com.sahaj.hms.domain.ts.TimeSlot;

public final class TimeSlotFactory implements Factory<TimeSlot,TimeSlotType>{

    @Override
    public TimeSlot getObject(TimeSlotType timeSlotType) {
        if(timeSlotType != null) {
            if(timeSlotType == TimeSlotType.DAY_TIME_SLOT) {
                return new DayTimeSlot();
            }
            else if(timeSlotType == TimeSlotType.NIGHT_TIME_SLOT) {
                return new NightTimeSlot();
            }
        }
        return null;
    }
}
