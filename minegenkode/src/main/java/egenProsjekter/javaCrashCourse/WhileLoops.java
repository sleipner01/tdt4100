package egenProsjekter.javaCrashCourse;

import java.util.Scanner;

public class WhileLoops {
    public static void main(String[] args) {
        int i = 5;
        while(i > 0) {
            System.out.println("Hello");
            i--;
        }

        Scanner scanner = new Scanner(System.in);
        String input = "";
        while(!input.equals("quit")) {
            System.out.println("Input:");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        }

        scanner.close();


        // Do while
        do {
            System.out.println("Input:");
            input = scanner.next().toLowerCase();
            System.out.println(input);
        } while(!input.equals("quit"));

        // break
        // continue

    }
}
