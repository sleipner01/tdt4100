package uke12.listener.stocks_forelesning;

public class RunMe {
    public static void main(String[] args) {
        Observable observable = new Observable();
        Observer observer = new Observer(observable);
        

        observable.updateStock("Equinoor", 500);
        observable.updateStock("Equinoor", 50);
        observable.updateStock("Frosta skotthyll&poff", 50);
    }
}
