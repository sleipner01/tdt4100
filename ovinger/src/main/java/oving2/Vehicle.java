package oving2;

public class Vehicle {
    private char vehicleType; 
    private char fuelType;
    private String registrationNumber;


    public Vehicle(char vehicleType, char fuelType, String registrationNumber) {
        if(isValidVehicleType(vehicleType)) this.vehicleType = vehicleType;
        else throw new IllegalArgumentException("Not a valid vehicle type");

        if(isValidFuelType(fuelType)) this.fuelType = fuelType;
        else throw new IllegalArgumentException("This is not a valid fuel type /(for this vehicle).");

        if(isValidRegistrationNumber(registrationNumber)) this.registrationNumber = registrationNumber;
        else throw new IllegalArgumentException("This is not a valid registration number.");
    }


    private boolean isValidVehicleType(char vehicleType) {
        if(vehicleType.) return false;
        return true;
    }

    private boolean isValidFuelType(char fuelType) {

        return true;
    }

    private boolean isValidRegistrationNumber(String registrationNumber) {

        return true;
    }


    public char getVehicleType() {
        return vehicleType;
    }


    public char getFuelType() {
        return fuelType;
    }


    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }


    @Override
    public String toString() {
        return "Vehicle [registrationNumber=" + registrationNumber + ", fuelType=" + fuelType + ", vehicleType="
                + vehicleType + "]";
    }

    
    
    
}
