package com.sahaj.hms.domain.ts;

import com.sahaj.hms.domain.enums.TimeSlotType;
import com.sahaj.hms.domain.ts.TimeSlot;

import java.time.LocalTime;

/**
 * Represent Day Time Slot
 * <p>
 * Night Time Slot Start Time - 6 AM
 * Night Time Slot End Time - 6 PM
 */

public class DayTimeSlot extends TimeSlot {
    private LocalTime startTime = LocalTime.of(6, 0);
    private LocalTime endTime = LocalTime.of(18, 0);
    private TimeSlotType timeSlotType = TimeSlotType.DAY_TIME_SLOT;
}
