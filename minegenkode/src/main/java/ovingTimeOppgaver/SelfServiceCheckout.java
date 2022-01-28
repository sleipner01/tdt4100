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

    public void registerPhoneNumber(String phoneNumber) {
        if(!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("This is not a valid norwegian phone number.");
        }

        this.phoneNumber = phoneNumber;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String cleanedPhoneNumber = phoneNumber.replaceAll("\\s.", "");

        if(cleanedPhoneNumber.startsWith("00479") || cleanedPhoneNumber.startsWith("00474")) {
            if(cleanedPhoneNumber.length() != 12) return false;
        }
        else if(cleanedPhoneNumber.startsWith("+479") || cleanedPhoneNumber.startsWith("+474")) {
            if(cleanedPhoneNumber.length() != 11) return false;
        }
        else return false;

        char[] chars = cleanedPhoneNumber.toCharArray();
        boolean isFirstIndex = true;
        for (char c : chars) {
            if (c == '+' && isFirstIndex) {
                isFirstIndex = false;
                continue;
            }
            if (!Character.isDigit(c)) return false;
        }

        return true;
    }

    public boolean scanItem(String product, int price, double discount) {
        return true;
    }

    public static void main(String[] args) {
        
    }

}
