package com.interlink.hotel.Apartment;

public class Apartment {

    private int number;
    private AccommodationType accommodationType;
    private ComfortType comfortType;
    private ApartmentStatus apartmentStatus;

    private Apartment() {
    }

    public ApartmentStatus getApartmentStatus() {
        return apartmentStatus;
    }

    public int getNumber() {
        return number;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public ComfortType getComfortType() {
        return comfortType;
    }

    public static ApartamentBuilder apartmentBuilder(){
        return new Apartment().new ApartamentBuilder();
    }

    public class ApartamentBuilder {

        private ApartamentBuilder() {
        }

        public ApartamentBuilder setAcomodationType(AccommodationType accommodationType){
            Apartment.this.accommodationType = accommodationType;
            return  this;
        }

        public ApartamentBuilder setComfortType(ComfortType comfortType){
            Apartment.this.comfortType = comfortType;
            return this;
        }

        public Apartment buildApartment(){
            return Apartment.this;
        }

        public ApartamentBuilder setApartmentStatus(ApartmentStatus apartmentStatus){
            Apartment.this.apartmentStatus = apartmentStatus;
            return this;
        }

        public ApartamentBuilder setNumber(int number){
            Apartment.this.number = number;
            return this;
        }
    }

    @Override
    public String toString() {
        return "Apartment{" +
                "number=" + number +
                ", accommodationType=" + accommodationType +
                ", comfortType=" + comfortType +
                '}';
    }
}
