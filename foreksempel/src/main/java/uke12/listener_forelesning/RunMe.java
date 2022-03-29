package uke12.listener_forelesning;

// Eksempelet er litt utvidet fra forelesning, og dekker interface av begge typer.
public class RunMe {
    public static void main(String[] args) {
        Observable observable = new Observable();
        PrintObserver observer = new PrintObserver(observable);
        FileObserver fileObserver = new FileObserver(observable);

        observable.updateStock("Equinoor", 500);
        observable.updateStock("Equinoor", 50);
        observable.updateStock("Frosta SkottHyllLag", 50);
        Thread thread = new Thread(observable);
        thread.start();
        System.out.println("Da venter vi!");
    }
}
