package inflearn.javaCodingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q2_12맨토링 {
    static int _numOfStudent = 4;
    static int _numOfTest = 3;
    static int[][] _inputs = {
            {3, 4, 1, 2},
            {4, 3, 2, 1},
            {3, 1, 4, 2}};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numOfStudent = scanner.nextInt();
        int numOfTest = scanner.nextInt();
        int[][] inputs = new int[numOfTest][numOfStudent];
        for (int i = 0; i < numOfTest; i++) {
            for (int j = 0; j < numOfStudent; j++) {
                inputs[i][j] = scanner.nextInt();
            }
        }
//        int result = countCase(_numOfStudent, _numOfTest, _inputs);
//        System.out.println(result);
        int result1 = countCase(numOfStudent, numOfTest, inputs);
        int result2 = solution(numOfStudent, numOfTest, inputs);
        int result3 = solution2(numOfStudent, numOfTest, inputs);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }

    private static int countCase(int numOfStudent, int numOfTest, int[][] inputs) {
        // 2차원배열을 2차원ArrayList로 옮긴다, lists.get(0)는 첫 시험의 등수들을 가짐
        List<List<Integer>> lists = new ArrayList<>();
        for (int i = 0; i < numOfTest; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < numOfStudent; j++) {
                list.add(inputs[i][j]);
            }
            lists.add(list);
        }

        int count = 0;
        for (int i = 0; i < numOfStudent; i++) { // (i+1)번 맨토
            for (int j = 0; j < numOfStudent; j++) { // (j+1)번 맨티
                boolean isPossible = true;
                if (i == j) continue;
                for (int k = 0; k < numOfTest; k++) { // 시험 수 만큼 반복
                    List<Integer> list = lists.get(k);
                    // 인덱스+1이 i+1번 맨토의 등수
                    int rankOfMentor = list.indexOf(i + 1) + 1;
                    int rankOfMentee = list.indexOf(j + 1) + 1;
                    if (rankOfMentor > rankOfMentee) {
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible) { // 모든 시험에 대해서 true면 (i+1)-(j+1)은 가능
//                    System.out.printf("가능: (%d번, %d번)\n", i + 1, j + 1);
                    count++;
                }
            }
        }
        return count;
    }

    /* 강의 풀이 */
    public static int solution(int n, int m, int[][] arr) {
        int answer = 0;
        for (int i = 1; i <= n; i++) { // 맨토 1~n번
            for (int j = 1; j <= n; j++) { // 맨티 1~n번
                int cnt = 0; // 맨토가 맨티보다 등수가 높은 시험 수 저장
                for (int k = 0; k < m; k++) { // 시험 수만큼 반복
                    int pi = 0, pj = 0;       // 시험 등수를 저장
                    for (int s = 0; s < n; s++) { // 한 시험의 결과 순환 (s=등수)
                        // arr[k][s]가 자신의 번호와 같다면 s가 자신의 등수
                        if (arr[k][s] == i) pi = s;
                        if (arr[k][s] == j) pj = s;
                    }
                    if (pi < pj) cnt++; // 맨토가 맨티보다 등수가 높으면 cnt++;
                }
                if (cnt == m) { // 맨토가 맨티보다 등수가 높은적이 == 시험 수 일 떄
                    answer++;   // 맨토-맨티 가능
//                    System.out.println(i+" "+j);
                }
            }
        }
        return answer;
    }

    // 강의 풀이 수정
    private static int solution2(int numOfStudent, int numOfTest, int[][] inputs) {
        int count = 0;
        for (int i = 0; i < numOfStudent; i++) {
            for (int j = 0; j < numOfStudent; j++) {
                if (i == j) continue;
                boolean isPossible = true;
                for (int k = 0; k < numOfTest; k++) {
                    // 모든 시험마다
                    int rankOfMentor = 0;
                    int rankOfMentee = 0;
                    for (int l = 0; l < numOfStudent; l++) {
                        // 한 시험안, 등수구하기
                        if (inputs[k][l] == i+1) rankOfMentor = l + 1;
                        if (inputs[k][l] == j+1) rankOfMentee = l + 1;
                    }
                    if (rankOfMentor > rankOfMentee) {
                        isPossible = false;
                        break;
                    }
                }
                if (isPossible) { // 모든 시험테스트후 조건통과시 count++;
//                    System.out.printf("(%d, %d)\n", i+1, j+1);
                    count++;
                }
            }
        }
        return count;
    }
}
