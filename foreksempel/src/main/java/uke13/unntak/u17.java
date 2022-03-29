package uke13.unntak;

import java.io.IOException;

public class u17 {

    private static void method3(String str) {
        double d = Double.valueOf(str);
        System.out.println("Made number: "+d);
    }

    private static void method2(String str)  {
        try {
            method3(str);
        } catch (IllegalArgumentException e) { // Trykk på unntaket, trykk F4 eller c-s-P 'show type hierarchy'
            System.out.println("Meep method2, IllegalArgumentException");
        }
    }

    private static void method1(String str) {
        try {
            method2(str);
        } catch (NumberFormatException e) { // Trykk på unntaket, trykk F4 eller c-s-P 'show type hierarchy'
            System.out.println("Meg fikse");
        }
    }
    
    public static void main(String[] args) {
        method1("3");
        method1("hei");
        // throw new RuntimeException(); marker unntaket, trykk på F4 for å se klassehierarki.

    }
}
