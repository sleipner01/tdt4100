package uke12.listener.stocks_forelesning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Observable {

    Map<String, Double> stocks = new HashMap<>();
    Collection<IObserver> observers = new ArrayList<>();;

    public void updateStock(String name, double value) {
        stocks.put(name, stocks.getOrDefault(name, 0.0) + value);
        System.out.println(name+" oppdater");
        notifyObservers(name);
    }

    private void notifyObservers(String name) {
        for (IObserver iobserver : observers) {
            iobserver.update(this, name);
        }
    }

    public void addObserver(IObserver observer) {
        this.observers.add(observer);
    }

    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }

    public double getStockValue(String name) {
        return stocks.get(name);
    }

}
