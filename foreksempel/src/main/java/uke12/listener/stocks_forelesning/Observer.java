package uke12.listener.stocks_forelesning;

public class Observer implements IObserver{

    public Observer(Observable observable) {
        observable.addObserver(this);
    }

    public void update(Observable observable, String name) {
        System.out.println("Ny endring i "+name+": "+
            observable.getStockValue(name));
    }

}
