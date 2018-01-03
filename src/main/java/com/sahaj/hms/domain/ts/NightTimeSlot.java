package com.sahaj.hms.domain.ts;

import com.sahaj.hms.domain.enums.TimeSlotType;
import com.sahaj.hms.domain.ts.TimeSlot;

import java.time.LocalTime;

/**
 * Represent Night Time Slot
 * <p>
 * Night Time Slot Start Time - 6 PM
 * Night Time Slot End Time - 6 AM
 */
public class NightTimeSlot extends TimeSlot {
    private static final LocalTime startTime = LocalTime.of(18, 0);
    private static final LocalTime endTime = LocalTime.of(6, 0);
    private TimeSlotType timeSlotType = TimeSlotType.NIGHT_TIME_SLOT;
}
