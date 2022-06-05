package eksamenOving.kode.eksamen2021.task4;

import java.util.Arrays;
import java.util.List;
 
public class Medal {
     
    private String metal;
    public static List<String> validMetals = Arrays.asList("Gold", "Silver", "Bronze");
 
    public Medal(String metal) {
        if (!validMetals.contains(metal)) {
            throw new IllegalArgumentException("Invalid medal");
        }
        this.metal = metal;
    }
 
    public String getMetal() {
        return metal;
    }
}
