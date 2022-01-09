package javaCrashCourse;

public class Primitive {
    
    public static void main(StringExamples[] args) {
        System.out.println("javaCrashCourse");
        // System.out.println("Hello Java!");

        // Integers
        int age = 30, temperature = 20;
        age = 35;
        System.out.println(age + "|" + temperature);

        int herAge = age;
        System.out.println(herAge);


        // Types: byte, short, int, long, float, double, char,  boolean

        byte myAge = 25;
        int viewCount = 123456789; // or 123_456_789
        long massiveViewCount = 3_123_456_789L;

        float price = 10.99F;
        char letter = 'A';
        boolean isEligible = true;

        if(isEligible) {
            System.out.println(myAge + " " + viewCount + " " + massiveViewCount + " " + price + " " + letter);
        }
    }
}
