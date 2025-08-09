package com.FlightBookingSystem.PassengerService;

public class Passenger {
    private int passengerId;
    private String passengerName;
    private String passengerMobile;
    private String passengerGender;
    private String passengerAadhaarNumber;
    private String passengerAddress;

    // No-argument constructor (required for serialization/deserialization)
    public Passenger() {
    }

    // Parameterized constructor for easy object creation
    public Passenger(int passengerId, String passengerName, String passengerMobile, String passengerGender,
                     String passengerAadhaarNumber, String passengerAddress) {
        this.passengerId = passengerId;
        this.passengerName = passengerName;
        this.passengerMobile = passengerMobile;
        this.passengerGender = passengerGender;
        this.passengerAadhaarNumber = passengerAadhaarNumber;
        this.passengerAddress = passengerAddress;
    }

    // Getters and setters
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerMobile() {
        return passengerMobile;
    }

    public void setPassengerMobile(String passengerMobile) {
        this.passengerMobile = passengerMobile;
    }

    public String getPassengerGender() {
        return passengerGender;
    }

    public void setPassengerGender(String passengerGender) {
        this.passengerGender = passengerGender;
    }

    public String getPassengerAadhaarNumber() {
        return passengerAadhaarNumber;
    }

    public void setPassengerAadhaarNumber(String passengerAadhaarNumber) {
        this.passengerAadhaarNumber = passengerAadhaarNumber;
    }

    public String getPassengerAddress() {
        return passengerAddress;
    }

    public void setPassengerAddress(String passengerAddress) {
        this.passengerAddress = passengerAddress;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", passengerName='" + passengerName + '\'' +
                ", passengerMobile='" + passengerMobile + '\'' +
                ", passengerGender='" + passengerGender + '\'' +
                ", passengerAadhaarNumber='" + passengerAadhaarNumber + '\'' +
                ", passengerAddress='" + passengerAddress + '\'' +
                '}';
    }
}
