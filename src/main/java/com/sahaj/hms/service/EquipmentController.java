package com.sahaj.hms.service;


import com.sahaj.hms.exception.IncorrectSensorInputException;
import com.sahaj.hms.service.impl.HotelServiceImpl;

/**
 * Starting point of the Program Execution.
 * <p>
 * This Class maintains {@link com.sahaj.hms.domain.common.Hotel} initialization using {@link HotelServiceImpl}
 * operations and maintains its equipment status using Rules
 */


public interface EquipmentController {
    public void control() throws IncorrectSensorInputException;
}
