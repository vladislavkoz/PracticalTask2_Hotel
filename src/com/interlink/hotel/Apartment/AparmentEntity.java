package com.interlink.hotel.Apartment;

public class AparmentEntity {
    AcomodationType acomodationType;

    public AparmentEntity(AcomodationType acomodationType) {
        this.acomodationType = acomodationType;
    }

    public AcomodationType getAcomodationType() {
        return acomodationType;
    }

    public void setAcomodationType(AcomodationType acomodationType) {
        this.acomodationType = acomodationType;
    }
}
