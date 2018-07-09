package com.interlink;

import com.interlink.hotel.Apartment.*;
import com.interlink.hotel.Client.Client;
import com.interlink.hotel.Reception.Period;
import com.interlink.hotel.Reception.Reception;
import com.interlink.hotel.Reception.Reservation;

import java.time.LocalDate;
import java.util.*;

import static java.time.LocalDate.now;

public class Main {

    public static void main(String[] args) {
//        Apartment apartment1 = Apartment.apartmentBuilder()
//                .setAccommodationType(AccommodationType.SGL)
//                .setComfortType(ComfortType.LUX)
//                .setNumber(1)
//                .setApartmentStatus(ApartmentStatus.FREE)
//                .buildApartment();
//        Apartment apartment2 = Apartment.apartmentBuilder()
//                .setAccommodationType(AccommodationType.DBL)
//                .setComfortType(ComfortType.LUX)
//                .setNumber(2)
//                .setApartmentStatus(ApartmentStatus.FREE)
//                .buildApartment();
//        Apartment apartment3 = Apartment.apartmentBuilder()
//                .setAccommodationType(AccommodationType.DBL)
//                .setComfortType(ComfortType.LUX)
//                .setNumber(3)
//                .setApartmentStatus(ApartmentStatus.FREE)
//                .buildApartment();



        List<ApartmentEntity>  apartments = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            ApartmentEntity apartmentEntity = new ApartmentEntity(AccommodationType.SGL,ComfortType.ECONOM);
            ApartmentEntity apartmentEntity3 = new ApartmentEntity(AccommodationType.SGL,ComfortType.STANDART);
//            ApartmentEntity apartmentEntity2 = new ApartmentEntity(AccommodationType.SGL,ComfortType.LUX);
            ApartmentEntity apartmentEntity1 = new ApartmentEntity(AccommodationType.DBL,ComfortType.LUX);
//            ApartmentEntity apartmentEntity5 = new ApartmentEntity(AccommodationType.DBL,ComfortType.STANDART);
            ApartmentEntity apartmentEntity4 = new ApartmentEntity(AccommodationType.DBL,ComfortType.LUX);
            apartments.add(apartmentEntity);
            apartments.add(apartmentEntity3);
//            apartments.add(apartmentEntity2);
            apartments.add(apartmentEntity1);
            apartments.add(apartmentEntity4);
//            apartments.add(apartmentEntity5);

        }

        Client client1 = new Client("Nazar","03289729384293",1);
        Client client2 = new Client("Valentin","03223436456456",2);
        Client client3 = new Client("Andrey","03289567354",2);
        Client client4 = new Client("Vova","032845622384293",2);
        Client client5 = new Client("Max","03289723456365",2);

        Map<Client,List<Reservation>> reservationsBook = new HashMap<>();

        Reception reception = new Reception(reservationsBook);
        reception.addApartments(apartments);

        Period per1 = new Period(LocalDate.now().plusDays(1),LocalDate.now().plusDays(7));
        Period per2 = new Period(LocalDate.now().plusDays(1),LocalDate.now().plusDays(4));//
        Period per3 = new Period(LocalDate.now().plusDays(5),LocalDate.now().plusDays(6));
        Period per4 = new Period(LocalDate.now(),LocalDate.now().plusDays(3));

        Reservation reservation1   = new Reservation(client1,apartments.get(0),per1);
        Reservation reservation2 = new Reservation(client5,apartments.get(2),per2);//
        Reservation reservation3 = new Reservation(client3,apartments.get(4),per3);
        Reservation reservation4 = new Reservation(client4,apartments.get(3),per3);//
        Reservation reservation5 = new Reservation(client2,apartments.get(5),per4);

        System.out.println(reception.makeReservation(reservation1));
        System.out.println(reception.makeReservation(reservation2));
        System.out.println(reception.makeReservation(reservation3));
        System.out.println(reception.makeReservation(reservation4));
        System.out.println(reception.makeReservation(reservation5));
        System.out.println("RezervationBook:  " + reception.getReservationBook().size());
        System.out.println(reception.getReservationBook());

        System.out.println("Free Rooms by criterions: " +
                reception.getFreeApartments(per1,ComfortType.LUX,AccommodationType.DBL));
    }
}
