package uke13.unntak;

public class u18 {
    
    private static void method4() {
        throw new IllegalArgumentException();
    }

    private static void method3() {
        try {
            method4();   
        } catch (NumberFormatException e) {
            System.out.println("Method3 caught "+e.getMessage());
        }
    }

    private static void method2() {
        try {
            method3();
        } catch (IndexOutOfBoundsException ioob){
            System.out.println("Hvorfor er jeg her, egentlig. Jo, for å vise at en "+
                "kan ha flere typer unntak etter hverandre.");
        } catch (IllegalArgumentException e) {
            System.out.println("Method2 caught "+e.getMessage());
        }
    }

    private static void method1() {
        try {
            method2();
        } catch (Exception e) {
            System.out.println("Method1 caugt "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        method1();
    }
}
