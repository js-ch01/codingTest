package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q7_04피보나치수열 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        fiboArr = new int[num + 1];
        fibo(num);
        for (int i = 1; i <= num; i++) { // 1 ~ num+1 순회
            System.out.print(fiboArr[i] + " ");
        }
    }

    static int[] fiboArr;

    private static int fibo(int n) {
        if (fiboArr[n] != 0) return fiboArr[n];

        if (n == 1 || n == 2) return fiboArr[n] = 1;

        return fiboArr[n] = fibo(n - 2) + fibo(n - 1);
    }
}
