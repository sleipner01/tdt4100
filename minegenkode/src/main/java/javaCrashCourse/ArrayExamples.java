package javaCrashCourse;

import java.util.Arrays;

public class ArrayExamples {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        numbers[0] = 1;
        numbers[1] = 2;
        System.out.println(Arrays.toString(numbers));


        int[] numbers2 = { 2, 3, 4, 7, 6, 5 };
        Arrays.sort(numbers2);
        System.out.println(Arrays.toString(numbers2));
        System.out.println(numbers2.length); // Arrays have fixed lengths

        System.out.println();


        int[][] numbers3 = new int[2][3];
        numbers3[0][0] = 1;
        System.out.println(Arrays.deepToString(numbers3));

        int[][] numbers4 = { { 1, 2 }, { 3, 4 } };
        System.out.println(Arrays.deepToString(numbers4));
    }
}
