package com.sahaj.hms.common;

public interface Operation<T>{
    public boolean saveEnergy(T e);
    public void revealCurrentStatus(T e);
}
