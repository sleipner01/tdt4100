package oving6.observable;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    private String ticker;
    private double sharePrice;
    private List<StockListener> listeners;

    public Stock(String ticker, double sharePrice) {
        this.ticker = ticker;
        this.sharePrice = sharePrice;
        this.listeners = new ArrayList<>();
    }

    public void setPrice(double sharePrice) {
        if(sharePrice <= 0) 
            throw new IllegalArgumentException("The price has to be above 0.");
        double oldSharePrice = this.getPrice();
        this.sharePrice = sharePrice;
        this.alertListeners(oldSharePrice);
    }

    private void alertListeners(double oldSharePrice) {
        this.listeners.forEach(listener -> listener.stockPriceChanged(this, oldSharePrice, sharePrice));
    }

    public String getTicker() {
        return this.ticker;
    }

    public double getPrice() {
        return this.sharePrice;
    }

    public void addStockListener(StockListener listener) {
        listeners.add(listener);
    }

    public void removeStockListener(StockListener listener) {
        listeners.remove(listener);
    }
}
