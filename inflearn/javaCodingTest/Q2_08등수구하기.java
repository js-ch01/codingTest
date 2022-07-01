package inflearn.javaCodingTest;

import java.util.*;

public class Q2_08등수구하기 {
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
        for (int rank : solution(num, scores)) {
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

    private static void printGrade(int[] nums) {
        // Map<점수, 동점자 수>, 점수 내림차순으로 정렬하는 map
        Map<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for (int num : nums) { // 점수별로 동점자 수센다
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int grade = 1;
        for (int key : map.keySet()) {
            int num = map.get(key); // 동점자 수
            map.put(key, grade); // 점수의 등수를 갱신한다
            grade += num; // 다음등수는 현재등수 + 인원수
        }

        for (int num : nums) {
            System.out.print(map.get(num) + " ");
        }
    }

    // 강의 풀이
    public static int[] solution(int n, int[] arr) {
        int[] answer = new int[n];
        // 자신보다 높은 점수의 개수 + 1이 자신의 등수
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
