package egenProsjekter.javaCrashCourse;

public class ArithmeticExpressions {
    public static void main(String[] args) {
        int addition = 10 + 3;
        System.out.println(addition);

        double division = (double)10 / (double)3;
        System.out.println(division);

        int x = 1;
        x++;
        ++x;
        System.out.println(x);

        System.out.println("-----------");

        int y = 1;
        int z = y++;
        System.out.println(y);
        System.out.println(z);
        System.out.println("-----------");
        y = 1;
        z = ++y;
        System.out.println(y);
        System.out.println(z);

        int h = 1;
        h += 3;
        h -= 1;
        h *= 1;
        h /= 1;
        System.out.println(h);

        System.out.println("--------");

        int expression = 10 + 3 * 2;
        System.out.println(expression);
        int expression2 = (10 + 3) * 2;
        System.out.println(expression2);

    }
}
