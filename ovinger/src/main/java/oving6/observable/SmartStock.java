package oving6.observable;

import java.util.HashMap;

public class SmartStock extends Stock {

    // Kommer ikke til å fullføre

    HashMap<StockListener, Double[]> intervalListeners = new HashMap<>();
    HashMap<StockListener, Double> diffListeners = new HashMap<>();

    public SmartStock(String ticker, double sharePrice) {
        super(ticker, sharePrice);
    }

    public void addStockListener(StockListener listener, double min, double max) {
        Double[] doubleArray = {min, max};
        intervalListeners.put(listener, doubleArray);
    }

    
}
