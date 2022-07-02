package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class Q2_09격자판_최대합 {
    static int _num = 5;
    static int[][] _inputs = {{10, 13, 10, 12, 15},
            {12, 39, 30, 23, 11},
            {11, 25, 50, 53, 15},
            {19, 27, 29, 37, 27},
            {19, 13, 30, 13, 19}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[][] inputs = new int[num][num];
        for (int i = 0; i < num; i++) {
            inputs[i] = new int[num];
            for (int j = 0; j < num; j++) {
                inputs[i][j] = scanner.nextInt();
            }
        }

        int result1 = getMaxLineTotal(num, inputs);
        int result2 = solution(num, inputs);
        System.out.println(result1);
        System.out.println(result2);
    }

    private static int getMaxLineTotal(int num, int[][] inputs) {
        int[] rowLineSum = new int[num]; // 행
        int[] colLineSum = new int[num]; // 열
        int[] diaLineSum = new int[2];   // 대각선
        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                rowLineSum[i] += inputs[i][j];
                colLineSum[j] += inputs[i][j];
                if (i == j) diaLineSum[0] += inputs[i][j];
                if (i + j == num - 1) diaLineSum[1] += inputs[i][j];
            }
        }

        // 값들을 모아서 처리한다
        int[][] sums = new int[][]{rowLineSum, colLineSum, diaLineSum};
        return Arrays.stream(sums)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElse(0);
    }

    // Stream.of 사용
    private static int getMaxSum(int num, int[][] nums) {
        int[] sumOfRow = new int[num]; // 행
        int[] sumOfCol = new int[num]; // 열
        int[] sumOfDia = new int[2];   // 대각선

        for (int i = 0; i < num; i++) {
            for (int j = 0; j < num; j++) {
                sumOfRow[i] += nums[i][j];
                sumOfCol[j] += nums[i][j];
                if (i == j) sumOfDia[0] += nums[i][j];
                if (i + j == num - 1) sumOfDia[1] += nums[i][j];
            }
        }

        return Stream.of(sumOfRow, sumOfCol, sumOfDia)
                .flatMapToInt(Arrays::stream)
                .max()
                .orElse(0);
    }

    // 강의 풀이
    public static int solution(int n, int[][] arr) {
        int answer = -2147000000;
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < n; j++) {
                sum1 += arr[i][j];
                sum2 += arr[j][i];
            }
            // 바로바로 최대값 비교
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1 = sum2 = 0;
        for (int i = 0; i < n; i++) {
            sum1 += arr[i][i];
            sum2 += arr[i][n - i - 1];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);

        return answer;
    }
}
