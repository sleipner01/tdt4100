package oving6.observable;

public interface StockListener {

	public void stockPriceChanged(Stock stock, double oldPrice, double newPrice);

}
