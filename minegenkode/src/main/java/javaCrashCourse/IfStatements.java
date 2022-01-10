package javaCrashCourse;

public class IfStatements {
    public static void main(String[] args) {
        int temperature = 20;
        if(temperature > 30) {
            System.out.println("It is hot today.");
            System.out.println("Drink a lot of water.");
        }
        else if (temperature > 20) 
            System.out.println("Beautiful day!");
        else System.out.println("Cold day...");


        int income = 120_000;
        boolean hasHighIncome = (income > 100_000);
        System.out.println(hasHighIncome);

    }
}
