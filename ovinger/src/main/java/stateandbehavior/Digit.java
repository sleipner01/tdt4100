package stateandbehavior;

public class Digit {

    int base;
    int value;

    private String digits = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";


    public Digit(int baseValue) {
        base = baseValue;
        value = 0;
    }

    public int getValue() {
        return value;
    }

    public boolean increment() {
        value++;
        if(value == base) {
            value = 0;
            return true;
        }
        return false;
    }

    public int getBase() {
        return base;
    }

    public static void main(String[] args) {
        Digit digit = new Digit(2);
        System.out.println(digit.getBase());
        digit.increment();
        System.out.println(digit.getValue());
        System.out.println(digit);
    }

    @Override
    public String toString() {
        if(base > 10) return "" + digits.charAt(value) + "";

        return "" + value + "";
    }
    
}
