package com.interlink;

import com.interlink.hotel.Apartment.AcomodationType;
import com.interlink.hotel.Apartment.Apartment;
import com.interlink.hotel.Apartment.ApartmentStatus;
import com.interlink.hotel.Apartment.ApartmentsType;
import com.interlink.hotel.Client.Client;
import com.interlink.hotel.Reception.Period;
import com.interlink.hotel.Reception.Reception;
import com.interlink.hotel.Reception.Reservation;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Apartment apartment1 = Apartment.apartmentBuilder()
                .setBalconyRoom(true)
                .setAcomodationType(AcomodationType.SGL)
                .setApartmentsType(ApartmentsType.LUX)
                .setNumber(1)
                .setApartmentStatus(ApartmentStatus.FREE)
                .buildApartment();
        Apartment apartment2 = Apartment.apartmentBuilder()
                .setBalconyRoom(true)
                .setAcomodationType(AcomodationType.DBL)
                .setApartmentsType(ApartmentsType.LUX)
                .setNumber(2)
                .setApartmentStatus(ApartmentStatus.FREE)
                .buildApartment();
        Apartment apartment3 = Apartment.apartmentBuilder()
                .setBalconyRoom(true)
                .setAcomodationType(AcomodationType.DBL)
                .setApartmentsType(ApartmentsType.LUX)
                .setNumber(3)
                .setApartmentStatus(ApartmentStatus.FREE)
                .buildApartment();
        List<Apartment>  apartments = new ArrayList<>();
        apartments.add(apartment1);
        apartments.add(apartment2);
        apartments.add(apartment3);

        Client client1 = new Client("Nazar","03289729384293",1);
        Client client2 = new Client("Valentin","03289729384293",2);
        Reservation reservation1 = new Reservation(client1.getId(),apartment1,new Period(LocalDate.now(),LocalDate.now().plusDays(7)));
        Reservation reservation2 = new Reservation(client2.getId(),apartment2,new Period(LocalDate.now(),LocalDate.now().plusDays(7)));
        Reservation reservation3 = new Reservation(client2.getId(),apartment3,new Period(LocalDate.now(),LocalDate.now().plusDays(7)));


        Map<Client,List<Reservation>> reservationsBook = new HashMap<>();
        List<Client> clients = new ArrayList<>();
        Reception reception = new Reception(apartments,reservationsBook);
        reception.setClients(clients);
        System.out.println(reception.getCountsFreeApartments());

        reception.addNewReservation(client1,reservation1);
        reception.addNewReservation(client2,reservation2);
        reception.addNewReservation(client2,reservation3);

        System.out.println(reception.getReservationBook());
        System.out.println(reception.getReservationBook().get(client2));
        System.out.println(reception.getCountsFreeApartments());
    }
}
