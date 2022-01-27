package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q3_5연속된_자연수의_합 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
//        int n = 15;
        int result = countCases(n);
        System.out.println(result);

        int result2 = solution(n);
        System.out.println(result2);
    }

    private static int countCases(int n) {
        int count = 0, sum = 0;
        int first = 1; // 연속된 자연수의 맨 앞

        for (int i = 1; i <= n / 2 + 1; i++) {
            sum += i;
            if (sum == n) count++;

            // 목표값을 넘으면 맨 앞의 수를 뺀다
            while (sum >= n) {
                sum -= first;
                first++;
                if (sum == n) count++;
            }
        }

        return count;
    }

    /* 강의 풀이 */
    public static int solution(int n) {
        int answer = 0;
        int cnt = 1; // 수열의 크기
        n--;
        while (n > 0) {
            cnt++;
            n = n - cnt;
            if (n % cnt == 0) {
//                System.out.println(n + " " + cnt);
                answer++;
            }
        }
        return answer;
    }

}
