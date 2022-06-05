package eksamenOving.kode.eksamen2021.task4;

import java.util.ArrayList;
import java.util.List;
 
public class Athlete {
     
    private List<Medal> medals = new ArrayList<Medal>();
    private String country;
    private String name;
 
    public Athlete(String country, String name, List<Medal> medals) {
        this.name = name;
        this.country = country;
        this.medals = new ArrayList<>(medals);
    }
 
    public List<Medal> getMedals() {
        return new ArrayList<>(medals);
    }
 
    public String getCountry() {
        return country;
    }
 
    public String getName() {
        return name;
    }
 
}