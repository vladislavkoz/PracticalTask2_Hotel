package com.interlink.hotel.Client;

import java.util.Objects;

public class Client {

    private String fullName;
    private String telephoneNumber;
    private int id;

    public Client(String fullName, String telephoneNumber, int id) {
        this.fullName = fullName;
        this.telephoneNumber = telephoneNumber;
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(fullName, client.fullName) &&
                Objects.equals(telephoneNumber, client.telephoneNumber);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fullName, telephoneNumber);
    }

    @Override
    public String toString() {
        return "Client{" +
                "fullName='" + fullName + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", id=" + id +
                '}';
    }
}
