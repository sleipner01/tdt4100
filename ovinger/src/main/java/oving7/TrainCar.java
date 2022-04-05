package oving7;

public class TrainCar {

    private int deadWeight;

    public TrainCar(int deadWeight) {
        this.deadWeight = deadWeight;
    }

    public int getTotalWeight() {
        return this.getDeadWeight();
    }

    public void setDeadWeight(int weight) {
        this.deadWeight = weight;
    }

    public int getDeadWeight() {
        return this.deadWeight;
    }
}
