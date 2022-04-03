package uke13.unntak;

public class u16 {

    private static void method3(String str) throws Exception {
        if (str.equals("hei"))
            throw new Exception("Feil!");
        else System.out.println("Du skrev "+str);
        }

    private static void method2(String str) throws Exception {
        method3(str);
    }

    private static void method1(String str) {
        try {
            method2(str);
        } catch (Exception e) {
            System.out.println("Let me take care of this: "+e.getLocalizedMessage());
        }
    }
    
    public static void main(String[] args) {
        method1("Ost");
        method1("hei");
    }
}
