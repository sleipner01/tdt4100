package oving7;

public class PassengerCar extends TrainCar {

    private int passengerCount;
    private final int defaultPassangerWeight = 80;

    public PassengerCar(int deadWeight, int passengerCount) {
        super(deadWeight);
        this.passengerCount = passengerCount;
    }

    private int getCargoWeight() {
        return this.getPassengerCount() * this.defaultPassangerWeight;
    }

    public int getPassengerCount() {
        return this.passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    @Override
    public int getTotalWeight() {
        return super.getTotalWeight() + this.getCargoWeight();
    }

    @Override
    public String toString() {
        return "PassengerCar: Total weight - " + this.getTotalWeight() + " | Passengers - " + this.getPassengerCount() + "\n";
    }
}
