package of3.kode;

import java.util.Arrays;
import java.util.List;

public class SelfServiceCheckout {

    public static final List<String> days = Arrays.asList("mon", "tue", "wed", "thu", "fri", "sat", "sun");

    private String day;
    private String phoneNumber;

    public SelfServiceCheckout(String day) {
        validateDay(day);
        this.day = day;
    }

    private void validateDay(String day) {
        if (!days.contains(day)) {
            throw new IllegalArgumentException("Invalid weekday");
        }
    }

    public void registerPhoneNumber(String phoneNumber) {
        if (this.phoneNumber != null) {
            /*
             * Her kaster vi IllegalStateException og ikke IllegalArgumentException
             * fordi argumentet i seg selv (telefonnummeret) kan være gyldig, men
             * det er ikke en gyldig tilstand å sette et nytt telefonnummer på nytt
             * når brukeren allerede har registrert et fra før
             */
            throw new IllegalStateException("Illegal operation: Phone number already registered");
        }
        if (!isValidPhoneNumber(phoneNumber)) {
            throw new IllegalArgumentException("Not a valid phone number!");
        }
        this.phoneNumber = phoneNumber;
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        String cleanedPhoneNumber = phoneNumber.replaceAll("\\s", "");
        if (cleanedPhoneNumber.startsWith("00479") || cleanedPhoneNumber.startsWith("00474")) {
            if (cleanedPhoneNumber.length() != 12) {
                return false;
            }
        } else if (cleanedPhoneNumber.startsWith("+479") || cleanedPhoneNumber.startsWith("+474")) {
            if (cleanedPhoneNumber.length() != 11) {
                return false;
            }
        } else {
            return false;
        }

        // Her kunne man også fjernet første tegn i charArrayen og sjekket resten
        // Dette kan vi gjøre siden vi allerede har validert de første 4-5 tegnene
        char[] chars = cleanedPhoneNumber.toCharArray();
        boolean firstIndex = true;
        for (char c : chars) {
            if (!Character.isDigit(c)) {
                if (c != '+' && !firstIndex) {
                    return false;
                }
                firstIndex = false;
            }
        }

        return true;
    }

    public void scanItem(String itemName, int amount, double price) {
        double rebate = 0.0;
        if (phoneNumber != null && day.equals("thu")) {
            rebate = 0.1;
        }
        System.out.println(amount + "x " + itemName + ": " + (price - (price * rebate)) + " kr");
    }

    @Override
    public String toString() {
        String receipt = """
                --------------------------------------
                Hva             Pris    MVA     Total
                """;

        // TODO: Skriv kode for å printe ut varer og pris
        // Hint: Du kan bruke følgende streng med format-funksjonen:

        // "%dx %s\t%.2f\t%.2f\t%.2f"

        /*
         * Forklaring:
         * %d representerer et heltall
         * %s representerer en streng
         * %.2f representerer et flyttall (og runder av til 2 desimaler)
         * \t representerer tabulator (å trykke på tab)
         */

        receipt += String.format(
                """
                        --------------------------------------
                        Total MVA                       %.2f
                        Total                           %.2f
                                Takk for at du handlet
                                    hos oss i OOP!
                        --------------------------------------
                        """);
        return receipt;
    }

    // main-metode for å teste koden
    public static void main(String[] args) {

        Item tomato = new Item("Tomat", 5, "fruit", "|| ||| | |||| |");
        Item cheese = new Item("Norvegia", 90, "diary", "| | ||||| | |||");
        Item cheese2 = new Item("Norvegia", 90, "diary", "| | ||||| | |||");
        Item tortillas = new Item("Lefser", 15, "taco", " | || | || ||||");
        Item groundMeat = new Item("Kjøttdeig", 29.99, "taco", "|||| || | |||||");

        // SelfServiceCheckout checkout = new SelfServiceCheckout("fri", "passord123");

        // checkout.scanItem(tomato);
        // checkout.scanItem(cheese);
        // checkout.scanItem(tortillas);
        // checkout.scanItem(groundMeat);
        // checkout.scanItem(cheese2);

        // System.out.println(checkout);

        // checkout.registerPhoneNumber("004742345678");
        // checkout.activateAdminMode("passord123");
        // checkout.removeFromCart(0);

        // System.out.println(checkout);
    }

}
