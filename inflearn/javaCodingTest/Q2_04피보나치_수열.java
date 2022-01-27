package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q2_04피보나치_수열 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
        int num = 10;
//        fibonacci1(num);
//        fibonacci2(num, 0, 1);
//        for (int i = 1; i <= num; i++) System.out.print(fibo(i) + " ");

        fibo = new int[num+1];
        fibonacci_cache(num);
        for (int i = 1; i <= num; i++) System.out.print(fibo[i] + " ");

    }

    private static void fibonacci1(int num) {
        int first = 1;
        int second = 1;
        System.out.print(first + " " + second + " ");
        for (int i = 2; i < num; i++) {
            int next = first + second;
            first = second;
            second = next;
            System.out.print(next + " ");
        }
    }

    private static void fibonacci2(int num, int first, int second) {
        if (num == 0) return;
        System.out.print(second + " ");
        int next = first + second;
        first = second;
        second = next;
        fibonacci2(num - 1, first, second);
    }

    // 단일값을 반환하는 fibo
    private static int fibo(int num) {
        if (num == 1 || num == 2) return 1;
        return fibo(num - 2) + fibo(num - 1);
    }

    static int[] fibo;
    // static변수에 값을 저장 Memoization(cache)
    private static int fibonacci_cache(int num) {
        if(num == 1 || num == 2) return fibo[num] = 1;
        if (fibo[num] > 0) return fibo[num];
        return fibo[num] = fibonacci_cache(num-2) + fibonacci_cache(num - 1);
    }

}
