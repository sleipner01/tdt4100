package javaCrashCourse;

public class Casting {
    public static void main(String[] args) {
        // Implicit casting
        // byte > short > int > long > float > double
        short x = 1;
        int y = x + 2;
        System.out.println(y);

        double z = 1.1;
        double h = z + 2;
        System.out.println(h);

        // Explicit casting
        double k = 1.1;
        int n = (int)k + 2;
        System.out.println(n);


        // Convert from string to different datatypes
        // Integer.parseInt();
        // Short.parseFloat();
        // Float.parseFloat();
        // Double.parseDouble();
    }
}