package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q2_10봉우리 {
    static int _num = 5;
    static int[][] _inputs = {{5, 3, 7, 2, 3},
            {3, 7, 1, 6, 1},
            {7, 2, 5, 3, 4},
            {4, 3, 6, 4, 1},
            {8, 7, 3, 5, 2}};

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
        int result = countPeaks(num, inputs);
//        int result = countPeaks(_num, _inputs);
        System.out.println(result);

        System.out.println();
    }

    private static int countPeaks(int num, int[][] inputs) {
        int count = 0;
        for (int i = 0; i < num; i++)
            for (int j = 0; j < num; j++)
                if (isPeak(i, j, inputs)) count++;

        return count;
    }

    private enum Direction {
        UP, RIGHT, DOWN, LEFT,
    }

    // inputs[row][col]이 봉우리인지 확인
    private static boolean isPeak(int row, int col, int[][] inputs) {
        // 상하좌우 반복
        for (Direction direction : Direction.values()) {
            int row2 = row;
            int col2 = col;
            switch (direction) {
                case UP:
                    row2--; break;
                case RIGHT:
                    col2++; break;
                case DOWN:
                    row2++; break;
                case LEFT:
                    col2--; break;
            }

            // 가장자리를 만나면 다음방향으로 넘어간다
            if (row2 < 0 || row2 >= inputs.length ||
                col2 < 0 || col2 >= inputs.length) continue;

            // 자신보다 큰 방향이 있다면 바로 false 반환
            if (inputs[row][col] <= inputs[row2][col2]) {
                return false;
            }
        }
        return true;
    }


    /* 강의 풀이 */

    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};

    public int solution(int n, int[][] arr) {
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean flag = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] >= arr[i][j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) answer++;
            }
        }
        return answer;
    }
}
