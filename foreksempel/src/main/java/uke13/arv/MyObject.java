package uke13.arv;

public class MyObject {
    
    @Override
    public String toString() {
        return "Hei";
        // return super.toString();
    }


    public void lala() {
        
    }
    public static void main(String[] args) {
        MyObject mo = new MyObject();
        System.out.println(mo);

        Object o = new Object();
        System.out.println(o.toString());
        
        // // Hva gjør den nå?
        Object o2 = new MyObject();
        System.out.println(o2.toString());
        MyObject mo2 = (MyObject) o2;
    }
}
