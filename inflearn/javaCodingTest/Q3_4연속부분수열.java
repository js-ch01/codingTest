package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q3_4연속부분수열 {
    static int _num = 8;
    static int _m = 6;
    static int[] _sequence = {1, 2, 1, 3, 1, 1, 1, 2};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int m = scanner.nextInt();
        int[] sequence = new int[num];
        for (int i = 0; i < num; i++) sequence[i] = scanner.nextInt();

//        int result = countSubsequence(_num, _m, _sequence);
//        System.out.println(result);
//        int num = 1_0000_0000;
//        int m = 10;
//        int[] sequence = new Random().ints(num, 1, 3).toArray();

        int result1 = countSubsequence(num, m, sequence);
        int result2 = solution(num, m, sequence);
        System.out.println(result1);
        System.out.println(result2);
    }

    private static int countSubsequence(int num, int m, int[] sequence) {
        long start = System.nanoTime();
        long end = System.nanoTime();
        int count = 0;

        for (int i = 0; i < num; i++) { // sequence[i]는 부분수열의 첫 숫자
            int sum = 0;
            for (int j = i; j < num; j++) { // i 부터 값을 누적
                sum += sequence[j];
                if (sum > m) { // 목표값을 넘으면 더이상 계산해볼 필요없이 다음 i로
                    break;
                } else if (sum == m) { // 목표값이 되면 count올리고 다음 i로
                    count++;
                    break;
                }
            }
        }
        System.out.printf("실행시간1: %10d ns\n", end - start);
        return count;
    }

    /* 강의 풀이 */
    public static int solution(int n, int m, int[] arr) {
        long start = System.nanoTime();
        long end = System.nanoTime();
        int answer = 0, sum = 0, lt = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) answer++;
            while (sum >= m) { // 목표값을 넘으면
                sum -= arr[lt++]; // 목표값보다 작아질 때 까지 왼쪽값을 뺀다
                if (sum == m) answer++;
            }
        }
        System.out.printf("실행시간2: %10d ns\n", end - start);
        return answer;
    }
}
