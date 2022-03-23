package uke12.listener.stocks_forelesning;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileObserver implements IObserver{

    public FileObserver(Observable observable) {
        observable.addObserver(this);
    }


    @Override
    public void update(Observable observable, String name) {
        try (PrintWriter printWriter = new PrintWriter(new BufferedWriter(
            new FileWriter("Fil.txt", true)))) {
            
        } catch (Exception e) {
        }
    }
    
}
