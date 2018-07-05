package com.interlink.hotel.Reception;

import com.interlink.hotel.Apartment.Apartment;
import com.interlink.hotel.Client.Client;

import java.util.List;
import java.util.Objects;

public class Reservation {

    private int clientId;
    private Apartment apartments;
    private Period period;

    public Reservation(int clientId, Apartment apartments, Period period) {
        this.clientId = clientId;
        this.apartments = apartments;
        this.period = period;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Apartment getApartments() {
        return apartments;
    }

    public void setApartments(Apartment apartments) {
        this.apartments = apartments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(apartments, that.apartments) &&
                Objects.equals(period, that.period);
    }

    @Override
    public int hashCode() {

        return Objects.hash(apartments, period);
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "clientId=" + clientId +
                ", apartments=" + apartments +
                ", period=" + period +
                '}';
    }
}
