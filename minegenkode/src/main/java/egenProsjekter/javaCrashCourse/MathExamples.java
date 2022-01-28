package egenProsjekter.javaCrashCourse;

public class MathExamples {
    public static void main(String[] args) {
        int round = Math.round(1.1F);
        System.out.println(round);
        int ceil = (int)Math.ceil(1.1F);
        System.out.println(ceil);
        int floor = (int)Math.floor(1.1F);
        System.out.println(floor);
        int max = Math.max(1, 2);
        System.out.println(max);
        int min = Math.max(1, 2);
        System.out.println(min);
        double rand = Math.random();
        System.out.println(rand);

        // Random between 0 and 100
        int rand2 = (int)Math.round(Math.random() * 100);
        int rand3 = (int) (Math.random() * 100);
        System.out.println(rand2 + "|" + rand3);
    }
}
