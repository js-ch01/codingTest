package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q2_07점수계산 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] inputs = new int[num];
        for (int i = 0; i < num; i++) {
            inputs[i] = scanner.nextInt();
        }
//        int[] inputs = Arrays.stream("1 0 1 1 1 0 0 1 1 0".split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
        int result = getScore(inputs);
        System.out.println(result);
    }

    private static int getScore(int[] inputs) {
        int totalScore = 0;
        int currentScore = 1;

        if (inputs[0] == 1) totalScore++; // 첫번째 문제는 따로처리
        for (int i = 1; i < inputs.length; i++) {
            if (inputs[i] == 1) {
                if (inputs[i - 1] == 1) {
                    currentScore++;
                }
                totalScore += currentScore;
            } else {
                currentScore = 1;
            }
        }
        return totalScore;
    }

    private static int getScore2(int[] nums) {
        int total = 0;
        int score = 1;
        for(int i = 0; i <nums.length; i++) {
            if (nums[i] == 0) {
                score = 1;
            } else {
                total += score++;
            }
        }
        return total;
    }

    // 강의 풀이
    public int solution(int[] arr) {
        int answer = 0, cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                cnt++;
                answer += cnt;
            } else cnt = 0;
        }
        return answer;
    }
}
