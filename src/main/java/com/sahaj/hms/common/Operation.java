package com.sahaj.hms.common;

public interface Operation<T>{
    public void saveEnergy(T e);
    public void revealCurrentStatus(T e);
}
