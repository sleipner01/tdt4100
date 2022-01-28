package ovingTimeOppgaver;

import java.util.List;
import java.util.Arrays;

public class SelfServiceCheckout {
    
    public static final List<String> days = Arrays.asList("mon", "tue", "wed", "thu", "fri", "sat", "sun");
    private String day;
    private String phoneNumber;

    public SelfServiceCheckout(String day) {
        validateDay(day);
        this.day = day;
    }

    private void validateDay(String day) {
        if(!days.contains(day))
            throw new IllegalArgumentException("Invalid weekday");
    }

    public static void main(String[] args) {
        
    }

}
