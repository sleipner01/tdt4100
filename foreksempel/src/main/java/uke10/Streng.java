package uke10;

import java.util.Iterator;

public class Streng implements Iterator<Character>{

    String streng;
    int pointer;

    public void setStreng(String streng) {
        this.streng = streng;
    }

    @Override
    public boolean hasNext() {
        return pointer < streng.length();
    }

    @Override
    public Character next() {
        char tmp = streng.charAt(pointer);
        pointer++;
        return tmp;
    }


    public static void main(String[] args) {
        Streng foo = new Streng();
        foo.setStreng("Hei på meg");

        while (foo.hasNext()) {
            char c = foo.next();
            System.out.println(c);
        }
    }
    
}
