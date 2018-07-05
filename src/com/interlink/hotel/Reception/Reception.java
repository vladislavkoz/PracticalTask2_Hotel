package com.interlink.hotel.Reception;

import com.interlink.hotel.Apartment.AcomodationType;
import com.interlink.hotel.Apartment.Apartment;
import com.interlink.hotel.Apartment.ApartmentStatus;
import com.interlink.hotel.Client.Client;

import java.util.*;

public class Reception {
    List<Apartment> freeApartments;
    List<Apartment> apartments;
    List<Client> clients;
    Map<Client,List<Reservation>> reservationBook;
    Map<AcomodationType,Integer> countsFreeApartments;

    public Reception(List<Apartment> apartments, Map<Client, List<Reservation>> reservationBook) {
        this.apartments = apartments;
        this.reservationBook = reservationBook;
        this.countsFreeApartments = setCountFreeApartments();
    }

    public List<Apartment> getApartments() {
        return apartments;
    }

    public List<Client> getClients() {
        return clients;
    }

    public Map<AcomodationType,Integer> getCountsFreeApartments() {
        return countsFreeApartments;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }

    public void setApartments(List<Apartment> apartments) {
        this.apartments = apartments;
    }

    public Map<Client, List<Reservation>> getReservationBook() {
        return reservationBook;
    }

    public void setReservationBook(Map<Client, List<Reservation>> reservationBook) {
        this.reservationBook = reservationBook;
    }

    public void addNewReservation(Client client,Reservation reservation){
        if (!reservationBook.containsKey(client)){
            this.reservationBook.put(client,new ArrayList<>(Arrays.asList(reservation)));
        }else{
            reservationBook.get(client).add(reservation);
        }
        countsFreeApartments.put(reservation.getApartments().getAcomodationType(),countsFreeApartments.get(reservation.getApartments().getAcomodationType()) - 1);
    }

    public void removeAllClientReservation(Client client){
        reservationBook.remove(client);
    }

    public void removeSomeClientReservation(Client client, List<Reservation> reservations){
        for (Reservation reservation : reservations){
            reservationBook.get(client).remove(reservation);
        }
    }

    public List<Apartment> getFreeApartments() {
        return freeApartments;
    }

    private Map<AcomodationType,Integer> setCountFreeApartments(){
        Map<AcomodationType,Integer> countFreeApartments = new HashMap<>();
        for (Apartment apartment  : this.apartments) {
            countFreeApartments.put(,0);
        }
        return countFreeApartments;
    }
}
