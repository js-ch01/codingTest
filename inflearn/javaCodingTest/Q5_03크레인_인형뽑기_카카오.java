package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Q5_03크레인_인형뽑기_카카오 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = scanner.nextInt();
            }
        }
        int m = scanner.nextInt();
        int[] moves = new int[m];
        for (int i = 0; i < m; i++) {
            moves[i] = scanner.nextInt();
        }

        int result = countRemoved(board, moves);
        System.out.println(result);
    }

    private static int countRemoved(int[][] board, int[] moves) {
        int count = 0;
        Stack<Integer> stack = new Stack<>();

        for (int move : moves) {
            int doll = getDoll(board, move);
            if (doll != 0) {
                if (stack.isEmpty()) stack.push(doll);
                else if (stack.peek() == doll) {
                    count += 2;
                    stack.pop();
                } else stack.push(doll);
            }
        }
        return count;
    }

    private static int getDoll(int[][] board, int move) {
        int doll = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][move - 1] != 0) {
                doll = board[i][move - 1];
                board[i][move - 1] = 0;
                break;
            }
        }
        return doll;
    }
}
