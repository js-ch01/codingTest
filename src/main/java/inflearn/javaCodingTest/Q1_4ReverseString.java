package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Q1_4ReverseString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String[] inputs = new String[num];
        for (int i = 0; i < num; i++) {
            inputs[i] = scanner.next();
        }
        reverseString(inputs);
        reverseStringByStream1(inputs);
    }

    private static void reverseString(String[] inputs) {
        for (String input : inputs) {
            input = new StringBuffer(input).reverse().toString();
            System.out.println(input);
        }
    }

    private static void reverseStringByStream1(String[] inputs) {
        Arrays.stream(inputs)
                .map(input -> new StringBuffer(input).reverse().toString())
                .forEach(reversed -> System.out.println(reversed));
    }
}