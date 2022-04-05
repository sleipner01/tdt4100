package oving7;

public class CargoCar extends TrainCar {

    private int cargoWeight;

    public CargoCar(int deadWeight, int cargoWeight) {
        super(deadWeight);
        this.cargoWeight = cargoWeight;
    }

    public int getCargoWeight() {
        return this.cargoWeight;
    }

    public void setCargoWeight(int cargoWeight) {
        this.cargoWeight = cargoWeight;
    }

    @Override
    public int getTotalWeight() {
        return super.getTotalWeight() + this.getCargoWeight();
    }

    @Override
    public String toString() {
        return "CargoCar: Total weight - " + this.getTotalWeight() + " | Cargo weight - " + this.getCargoWeight() + "\n";
    }

}
