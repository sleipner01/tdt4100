package uke2;

import org.w3c.dom.ls.LSException;

public class TellNed {

    int igjen;

    private TellNed(int igjen) {
        this.igjen = igjen;
    }

    private void start() {
        while (this.igjen >= 0) {
            System.out.println("Det er igjen "+this.igjen+" sekunder til forelesning. Omtrent.");
            this.igjen -= 1;
            try {Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Ferdig!");
    }
    public static void main(String[] args) {
        TellNed tellned = new TellNed(10);
        tellned.start();



    }
}
