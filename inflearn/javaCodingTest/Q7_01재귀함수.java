package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q7_01재귀함수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        printN(num);
    }

    private static void printN(int n) {
        if (n == 0) return;
        printN(n - 1);
        System.out.print(n + " ");
    }
}
