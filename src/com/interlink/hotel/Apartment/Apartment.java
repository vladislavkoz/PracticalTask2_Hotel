package com.interlink.hotel.Apartment;

public class Apartment {

    private int number;
    private boolean balconyRoom;
    private AcomodationType acomodationType;
    private ApartmentsType apartmentsType;
    private ApartmentStatus apartmentStatus;

    private Apartment() {
    }

    public ApartmentStatus getApartmentStatus() {
        return apartmentStatus;
    }

    public int getNumber() {
        return number;
    }

    public boolean isBalconyRoom() {
        return balconyRoom;
    }

    public AcomodationType getAcomodationType() {
        return acomodationType;
    }

    public ApartmentsType getApartmentsType() {
        return apartmentsType;
    }

    public static ApartamentBuilder apartmentBuilder(){
        return new Apartment().new ApartamentBuilder();
    }

    public class ApartamentBuilder {

        private ApartamentBuilder() {
        }

        public ApartamentBuilder setAcomodationType(AcomodationType acomodationType){
            Apartment.this.acomodationType = acomodationType;
            return  this;
        }

        public ApartamentBuilder setApartmentsType(ApartmentsType apartmentsType){
            Apartment.this.apartmentsType = apartmentsType;
            return this;
        }

        public ApartamentBuilder setBalconyRoom(boolean balconyRoom){
            Apartment.this.balconyRoom = balconyRoom;
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
                ", balconyRoom=" + balconyRoom +
                ", acomodationType=" + acomodationType +
                ", apartmentsType=" + apartmentsType +
                '}';
    }
}
