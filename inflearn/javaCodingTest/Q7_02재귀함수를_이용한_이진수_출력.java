package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q7_02재귀함수를_이용한_이진수_출력 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        printBinary(num);
    }

    private static void printBinary(int num) {
        if (num == 0) return;
        printBinary(num / 2);
        System.out.print((num % 2));
    }
}