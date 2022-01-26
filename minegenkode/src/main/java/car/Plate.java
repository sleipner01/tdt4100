package car;

import java.util.regex.Pattern;

public class Plate {

    private String sign;

    public Plate(String sign) {
        if (checkSign(sign)) this.sign = sign;
        else throw new IllegalStateException("The sign is illigal" + sign);
    }

    private static boolean checkSign(String sign) {
        return Pattern.matches("[A-Z]{2}[1-9]{1}[0-9]{4}", sign);
    }

    public String getSign() {
        return sign;
    }

    public static void main(String[] args) {
        System.out.println();
        System.out.println();


        Plate plate = new Plate("AA41383");
        System.out.println(plate);


        System.out.println();
        System.out.println();

    }

    @Override
    public String toString() {
        return sign;
    }

    
    
}
