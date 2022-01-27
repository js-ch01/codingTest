package inflearn.javaCodingTest;

import java.util.Scanner;

//public class inflearn.javaCodingTest.Q2_6ReversedPrime {
public class Q2_06뒤집은_소수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] inputs = new int[num];
        for (int i = 0; i < num; i++) {
            inputs[i] = scanner.nextInt();
        }
//        int[] inputs = Arrays.stream("32 55 62 20 250 370 200 30 100".split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
        isReversedPrime(inputs);
    }

    private static void isReversedPrime(int[] inputs) {
        long start = System.nanoTime();

        for (int input : inputs) {
            int reversed = getReversedInt(input);
            if (isPrime(reversed))
                System.out.print(reversed + " ");
        }

        long end = System.nanoTime();
//        System.out.printf("실행시간: %10d ns\n", end-start);
    }

    private static int getReversedInt(int num) {
        int reversed = 0;
        while (num > 0) {
            reversed = (reversed * 10) + num % 10;
            num /= 10;
        }
        return reversed;
    }

    private static boolean isPrime(int num) {
        if (num <= 1) return false;

        for (int i = 2; i < num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
