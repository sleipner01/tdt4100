package egenProsjekter.javaCrashCourse;

public class LogicalOperators {
    public static void main(String[] args) {
        int temperature = 22;
        boolean isWarm = temperature > 20 && temperature < 30; // or = || not = !
        System.out.println(isWarm);

        System.out.println(!true);
    }
}
