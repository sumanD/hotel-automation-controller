package com.sahaj.hms.domain.ts;

import com.sahaj.hms.domain.enums.TimeSlotType;

import java.time.LocalTime;

/**
 * Represents a Time Slot, e.g., Day time slot , Night Time Slot etc
 */
public abstract class TimeSlot {
    private LocalTime startTime;
    private LocalTime endTime;
    private TimeSlotType timeSlotType;
}
