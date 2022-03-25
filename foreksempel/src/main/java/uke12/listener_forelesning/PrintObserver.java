package uke12.extra_listener;

import java.text.DecimalFormat;

public class PrintObserver implements IObserver{

    IObservable observable;
    DecimalFormat df = new DecimalFormat("##.#");

    

    public PrintObserver(IObservable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }


    @Override
    public void update(IObservable observable, String name) {
        System.out.println(name+": "+df.format(observable.getStock(name)));
    }

}
