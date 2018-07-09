package com.interlink.hotel.Reception;

import com.interlink.hotel.Apartment.ApartmentEntity;
import com.interlink.hotel.Client.Client;


public class Reservation {

    private Client client;
    private ApartmentEntity apartments;
    private Period period;

    public Reservation(Client client, ApartmentEntity apartments, Period period) {
        this.client = client;
        this.apartments = apartments;
        this.period = period;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public ApartmentEntity getApartment() {
        return apartments;
    }

    public void setApartments(ApartmentEntity apartments) {
        this.apartments = apartments;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                ", apartments=" + apartments +
                ", period=" + period +
                '}';
    }
}
