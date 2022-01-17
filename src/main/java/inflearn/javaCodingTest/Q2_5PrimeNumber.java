package inflearn.javaCodingTest;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Q2_5PrimeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
//        int num = 20;
        int result1 = countPrimeNumber1(num);
        int result2 = countPrimeNumber2(num);
        System.out.println(result1);
        System.out.println(result2);
    }

    private static int countPrimeNumber1(int num) {
        long start = System.nanoTime();
        boolean[] isNotPrime = new boolean[num + 1];

        int count = 0;

        for (int i = 2; i <= num; i++) {
            if(!isNotPrime[i]) {
                // 소수의 배수는 false
                for (int k = 2; k * i <= num; k++) {
                    isNotPrime[k * i] = true;
                }
                count++;
            }
        }
        long end = System.nanoTime();
        System.out.printf("실행시간1: %10d ns\n", end-start);
        return count;
    }

    private static int countPrimeNumber2(int num) {
        long start = System.nanoTime();
        int count = 0;

        for (int i = 2; i <= num; i++) {
            count++; // 일단 1 올린다
            for (int j = 2; j < i; j++) { // 2 ~ (i-1)로 나눠본다
                if (i % j == 0) {
                    count--; // 약수가 발견되면 1감소
                    break;
                }
            }
        }

        long end = System.nanoTime();
        System.out.printf("실행시간2: %10d ns\n", end-start);
        return count;
    }
}
