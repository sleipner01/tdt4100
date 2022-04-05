package oving7;

import java.util.ArrayList;
import java.util.List;

public class Train {
    
    List<TrainCar> carts = new ArrayList<>();

    public Train() {

    }

    public void addTrainCar(TrainCar trainCar) {
        carts.add(trainCar);
    }

    public boolean contains(TrainCar trainCar) {
        return carts.contains(trainCar);
    }

    public int getTotalWeight() {
        return carts.stream().mapToInt(cart -> cart.getTotalWeight()).sum(); 
    }

    public int getPassengerCount() {
        return carts.stream()
                    .filter(cart -> cart instanceof PassengerCar)
                    .map(cart -> (PassengerCar)cart)
                    .mapToInt(cart -> cart.getPassengerCount())
                    .sum(); 
    }

    public int getCargoWeight() {
        return carts.stream()
                    .filter(cart -> cart instanceof CargoCar)
                    .map(cart -> (CargoCar)cart)
                    .mapToInt(cart -> cart.getCargoWeight())
                    .sum(); 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Train:\n");
        carts.forEach(sb::append);
        return sb.toString();
    }
}
