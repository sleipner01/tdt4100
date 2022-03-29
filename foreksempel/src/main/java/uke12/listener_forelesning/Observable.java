package uke12.extra_listener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Observable implements IObservable, Runnable{
    
    Collection<IObserver> observers = new ArrayList<>();
    HashMap<String, Double> stocks = new HashMap<>();
    Random random = new Random();

    @Override
    public double getStock(String name) {return stocks.get(name);} 

    public void updateStock(String name, double value) {
        stocks.put(name, stocks.getOrDefault(name, 0.0) + value);
        notifyListener(name);
    }

    private void notifyListener(String name) {
        for (IObserver observer : observers) {
            observer.update(this, name);
        }
    }
    @Override
    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

    @Override
    public void addObserver(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                List<String> names = List.of("Equinoor", "DnBee", "Slemdal Skotthyllforening ASA");
                double moneys = random.nextDouble(10)-5;
                updateStock(names.get(random.nextInt(names.size())), moneys);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
