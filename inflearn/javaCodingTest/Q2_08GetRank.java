package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Q2_08GetRank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        int num = scanner.nextInt();
//        int[] scores = new int[num];
//        for (int i = 0; i < num; i++) {
//            scores[i] = scanner.nextInt();
//        }
        int[] scores = Arrays.stream("87 89 92 100 76".split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int num = scores.length;

        getGrade(num, scores);
        System.out.println();
        for(int rank : solution(num, scores)) {
            System.out.print(rank + " ");
        }
    }

    private static void getGrade(int num, int[] scores) {
        int[] ranks = new int[num];
        Arrays.fill(ranks, num); // 모두 꼴등에서 시작

        // 서로 비교하여 점수가 높은쪽의 등수를 1줄인다
        for (int i = 0; i < num; i++) {
            for (int j = i + 1; j < num; j++) {
                if (scores[i] > scores[j]) {
                    ranks[i]--;
                } else if (scores[i] < scores[j]) {
                    ranks[j]--;
                } else { // 점수가 같은 경우
                    ranks[i]--;
                    ranks[j]--;
                }
            }
        }

        for (int rank : ranks) System.out.print(rank + " ");
    }

    // 강의 풀이
    public static int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] > arr[i]) cnt++;
            }
            answer[i] = cnt;
        }
        return answer;
    }
}
