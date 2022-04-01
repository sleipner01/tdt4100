package oving6.observable;

public interface StockListener {

    void stockPriceChanged(Stock stock, double oldValue, double newValue);

}
