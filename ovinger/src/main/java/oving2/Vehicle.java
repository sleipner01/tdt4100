package oving2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Vehicle {
    private char vehicleType; 
    private char fuelType;
    private String registrationNumber;

    private char car = 'C';
    private char motorcycle = 'M';
    private char gasoline = 'G';
    private char diesel = 'D';
    private char electric = 'E';
    private char hydrogen = 'H';

    private List<String> validHydrogenRegistered = Arrays.asList("HY");
    private List<String> validElectricRegistered = Arrays.asList("EL", "EK");
    private List<Character> validVehicleTypes =  Arrays.asList(car, motorcycle);
    private List<Character> validFuelTypes =  Arrays.asList(gasoline, diesel, electric, hydrogen);


    public Vehicle(char vehicleType, char fuelType, String registrationNumber) throws IllegalArgumentException {
        if(isValidVehicleType(vehicleType)) this.vehicleType = vehicleType;
        else throw new IllegalArgumentException("Not a valid vehicle type");
        System.out.println(this.vehicleType);

        if(isValidFuelType(fuelType)) this.fuelType = fuelType;
        else throw new IllegalArgumentException("This is not a valid fuel type /(for this vehicle).");
        System.out.println(this.fuelType);

        if(isValidRegistrationNumber(registrationNumber)) this.registrationNumber = registrationNumber;
        else throw new IllegalArgumentException("This is not a valid registration number to this car/fuel.");
    }


    private boolean isValidVehicleType(char vehicleType) {
        if(validVehicleTypes.contains(vehicleType)) return true;
        return false;
    }

    private boolean isValidFuelType(char fuelType) {
        if(!validFuelTypes.contains(fuelType)) return false;
        if(this.vehicleType == motorcycle && fuelType == hydrogen) return false;

        return true;
    }

    private boolean isValidRegistrationNumber(String registrationNumber) {
        if(this.vehicleType == motorcycle)
            if(!Pattern.matches("[A-Z]{2}[0-9]{4}", registrationNumber)) return false;
        System.out.println("Nice");
        if(this.vehicleType == car)
            if(!Pattern.matches("[A-Z]{2}[0-9]{5}", registrationNumber)) return false;
        System.out.println("Nice2");


        String initials = registrationNumber.substring(0, 2);
        System.out.println("Nice3");
        if(this.fuelType == electric)
            if(!validElectricRegistered.contains(initials)) return false;
        System.out.println("Nice4");
        if(this.fuelType == hydrogen)
            if(!validHydrogenRegistered.contains(initials)) return false;
        System.out.println("Nice5");
        if(this.fuelType == gasoline || this.fuelType == diesel)
            if(validElectricRegistered.contains(initials) || validHydrogenRegistered.contains(initials)) return false;

        return true;
    }


    public char getVehicleType() {
        return this.vehicleType;
    }


    public char getFuelType() {
        return this.fuelType;
    }


    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) throws IllegalArgumentException {
        if(!isValidRegistrationNumber(registrationNumber))
            throw new IllegalArgumentException("This sign cannot be used on this vehicle/fuel");
        this.registrationNumber = registrationNumber;
    }


    public static void main(String[] args) {
        Vehicle car = new Vehicle('C', 'G', "DN52448");
    }


    @Override
    public String toString() {
        return "Vehicle [registrationNumber=" + registrationNumber + ", fuelType=" + fuelType + ", vehicleType="
                + vehicleType + "]";
    }
}