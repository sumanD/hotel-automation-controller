package com.sahaj.hms.common;

public interface Factory<T,E> {
    public T getObject(E e);
}
