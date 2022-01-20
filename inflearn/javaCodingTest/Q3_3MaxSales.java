package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q3_3MaxSales {
    static int _day = 10;
    static int _k = 3;
    static int[] _sales = {12, 15, 11, 20, 25, 10, 20, 19, 13, 15};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int day = scanner.nextInt();
        int k = scanner.nextInt();
        int[] sales = new int[day];
        for (int i = 0; i < day; i++) sales[i] = scanner.nextInt();

//        int result = getMaxSales(_day, _k, _sales);
        int result = getMaxSales(day, k, sales);
        System.out.println(result);
    }

    private static int getMaxSales(int day, int k, int[] sales) {
        int max = 0, sum = 0;
        // 첫 k일의 합
        for (int i = 0; i < k; i++) {
            sum += sales[i];
        }
        max = sum;

        for (int i = k; i < day; i++) {
            // K일의 맨 앞 매출을 빼고 새 매출을 더한다
            sum += -sales[i-k] + sales[i];
            max = Math.max(max, sum);
        }

        return max;
    }
}
