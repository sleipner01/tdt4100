package uke12.extra_listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileObserver implements IObserver {

    IObservable iObservable = new Observable();

    public FileObserver(IObservable observable) {
        this.iObservable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(IObservable observable, String name) {

        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter("Fil.txt", true)))) {
            printWriter.print("Lagret ny aksje: "+name+" ("+observable.getStock(name)+")\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
