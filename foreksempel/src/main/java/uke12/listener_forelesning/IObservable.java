package uke12.extra_listener;

public interface IObservable {
    public void updateStock(String name, double value);
    public void addObserver(IObserver observer);
    public void removeObserver(IObserver observer);
    public double getStock(String name);
}
