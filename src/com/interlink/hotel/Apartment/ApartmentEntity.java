package com.interlink.hotel.Apartment;

import java.util.Objects;

public class ApartmentEntity {
    private int id;
    private AccommodationType accommodationType;
    private ComfortType comfortType;

    public ApartmentEntity(AccommodationType accommodationType, ComfortType comfortType) {
        this.accommodationType = accommodationType;
        this.comfortType = comfortType;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public ComfortType getComfortType() {
        return comfortType;
    }

    public void setComfortType(ComfortType comfortType) {
        this.comfortType = comfortType;
    }

    public void setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "{ ID: " + this.id
                + ", AccommodationType: " + this.accommodationType.name()
                + ", ComfortType: " + this.comfortType.name()
                + " }";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApartmentEntity that = (ApartmentEntity) o;
        return id == that.id &&
                accommodationType == that.accommodationType &&
                comfortType == that.comfortType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accommodationType, comfortType);
    }
}
