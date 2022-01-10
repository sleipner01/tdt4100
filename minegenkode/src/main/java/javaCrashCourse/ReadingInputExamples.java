package javaCrashCourse;

import java.util.Scanner;

public class ReadingInputExamples {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Age: ");
        byte age = scanner.nextByte();
        System.out.println("You are " + age);

        System.out.print("Name: ");
        String name = scanner.next();
        System.out.println("You are " + name);

        // To get everything (Every token)
        System.out.print("Name: ");
        String name2 = scanner.nextLine();
        System.out.println("You are " + name2);

        scanner.close();
    }
}
