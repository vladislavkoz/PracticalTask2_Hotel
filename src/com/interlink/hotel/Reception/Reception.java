package com.interlink.hotel.Reception;

import com.interlink.hotel.Apartment.*;
import com.interlink.hotel.Client.Client;

import java.util.*;
import java.util.stream.Collectors;

public class Reception {
    int countOfApartments;
    List<ApartmentEntity> apartments;
    Map<Client,List<Reservation>> reservationBook;

    public Reception( Map<Client, List<Reservation>> reservationBook) {
        this.reservationBook = reservationBook;
        this.countOfApartments = 0;
    }

    public List<ApartmentEntity> getApartments() {
        return apartments;
    }

    public void addApartments(List<ApartmentEntity> apartments) {
        for (ApartmentEntity apartment : apartments) {
            apartment.setId(1 + countOfApartments++);
        }
        System.out.println(countOfApartments);
        this.apartments = apartments;
    }

    public Map<Client, List<Reservation>> getReservationBook() {
        return reservationBook;
    }

    public void setReservationBook(Map<Client, List<Reservation>> reservationBook) {
        this.reservationBook = reservationBook;
    }

    private List<ApartmentEntity> getApartmentsByAcomodation(List<ApartmentEntity> apartments,AccommodationType accommodationType){
        return apartments.stream()
                .filter(apartmentEntity -> apartmentEntity.getAccommodationType() == accommodationType)
                .collect(Collectors.toList());
    }

    private List<ApartmentEntity> getApartmentsbyComfortType(List<ApartmentEntity> apartments, ComfortType comfortType){
        return apartments.stream()
                .filter(apartmentEntity -> apartmentEntity.getComfortType() == comfortType)
                .collect(Collectors.toList());
    }

    private List<ApartmentEntity> getReservedApartmentsByPeriod(Period period){
        return this.reservationBook.values().stream()
                .flatMap(Collection::stream)
                .filter(reservation -> reservation.getPeriod().isIntersectWith(period))
                .map(Reservation::getApartment)
                .collect(Collectors.toList());
    }

    private boolean isValidReservation(Reservation reservation){
        int reservedApartments =  getApartmentsbyComfortType(getApartmentsByAcomodation(getReservedApartmentsByPeriod(reservation.getPeriod()),reservation.getApartment().getAccommodationType()),reservation.getApartment().getComfortType()).size();
        int totalApartments = getApartmentsbyComfortType(getApartmentsByAcomodation(this.apartments,reservation.getApartment().getAccommodationType()),reservation.getApartment().getComfortType()).size();
        return totalApartments > reservedApartments;
    }

    public boolean makeReservation(Reservation reservation){
        if (!isValidReservation(reservation)){
            return false;
        }
        if (reservationBook.get(reservation.getClient()) == null){
            this.reservationBook.put(reservation.getClient(),new ArrayList<>(Collections.singletonList(reservation)));
        }

        return true;
    }

    private List<ApartmentEntity> getFreeApartmentsByPeriod(Period period) {
        List<ApartmentEntity> totalApartments = new ArrayList<>(this.apartments);
        List<ApartmentEntity> reservedApartments = getReservedApartmentsByPeriod(period);
        totalApartments.removeAll(reservedApartments);
        return totalApartments;
    }

    private List<ApartmentEntity> validateApartmentsByCriterion(List<ApartmentEntity>  apartmentsByPeriod,Criterion...criterions){
        List<ApartmentEntity> apartments = new ArrayList<>(apartmentsByPeriod);
        for (ApartmentEntity apartment : apartmentsByPeriod) {
            if (!validateSomeApartment(apartment,criterions)){
                apartments.remove(apartment);
            }
        }
        return apartments;
    }

    private boolean validateSomeApartment(ApartmentEntity apartment ,Criterion...criterions){
        for (Criterion c: criterions) {
            if (!c.validate(apartment)){
                return false;
            }
        }
        return true;
    }

    public List<ApartmentEntity> getFreeApartments(Period period,Criterion...criterions){
        return validateApartmentsByCriterion(getFreeApartmentsByPeriod(period),criterions);
    }
}
