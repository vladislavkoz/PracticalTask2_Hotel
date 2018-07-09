package com.interlink.hotel.Apartment;

public enum ComfortType implements Criterion {
    STANDART,ECONOM,LUX;


    @Override
    public boolean validate(ApartmentEntity apartment) {
        return this == apartment.getComfortType();
    }
}
