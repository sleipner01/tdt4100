package eksamenOving.kode.eksamen2021.task3;

import java.util.ArrayList;
import java.util.Collection;

public class Logger {
 
    // This is only for testing
    Collection<String> hasLogged = new ArrayList<>();
 
    public void log(String log) {
        System.out.println(log);
        hasLogged.add(log);
    }
}
