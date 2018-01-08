package com.sahaj.hms.common;

import com.sahaj.hms.exception.HmsBaseException;
import com.sahaj.hms.exception.ValidationException;

public interface Operation<T>{
    public boolean saveEnergy(T e) throws ValidationException;
    public void revealCurrentStatus(T e) throws ValidationException;
}
