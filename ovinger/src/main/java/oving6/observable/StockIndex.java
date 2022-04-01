package oving6.observable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockIndex implements StockListener {

    //private String indexName;
    private double index;
    private List<Stock> indexStocks;

    public StockIndex(String indexName, Stock... stocks) {
        //this.indexName = indexName;
        this.indexStocks = new ArrayList<>(Arrays.asList(stocks));
        this.updateIndex();
    }

    public void addStock(Stock stock) {
        //if(indexStocks.contains(stock))
        //    throw new IllegalArgumentException("This stock is already tracked.");
        if(!this.indexStocks.contains(stock)) this.indexStocks.add(stock);
        this.updateIndex();
    }

    public void removeStock(Stock stock) {
        //if(!indexStocks.contains(stock))
        //   throw new IllegalArgumentException("This stock isn't tracked in this index.");
        if(this.indexStocks.contains(stock)) this.indexStocks.remove(stock);
        this.updateIndex();
    }

    public double getIndex() {
        this.updateIndex();
        return this.index;
    }

    private void updateIndex() {
        this.index = 0;
        this.indexStocks.forEach(stock -> this.index += stock.getPrice());
    }

    @Override
    public void stockPriceChanged(Stock stock, double oldValue, double newValue) {
        if(!this.indexStocks.contains(stock))
            throw new IllegalArgumentException("This index does not track " + stock);
        this.updateIndex();
    }
    
}
