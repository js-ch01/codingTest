package inflearn.javaCodingTest;

import java.util.Scanner;
import java.util.Stack;

public class Q5_05쇠막대기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        int result = countPieces(input);
        System.out.println(result);
    }

    private static int countPieces(String input) {
        int result = 0;
        int height = 0; // 쌓은 쇠막대기의 개수
        input += ' '; // 마지막 항 다음 처리를 위해

        for (int i = 0; i < input.length() - 1; i++) {
            char ch = input.charAt(i);
            char nextCh = input.charAt(i + 1);

            if (ch == '(' && nextCh == ')') { // 레이저부분
                result += height;   // 쌓은 쇠막대기 개수만큼 추가
                i += 1;             // 다음')'을 스킵하기 위해
            } else if (ch == '(') { // 맨 위 쇠막대기의 시작부분
                height++;           // 쇠막대기 추가
            } else if (ch == ')') { // 맨 위 쇠막대기의 끝부분
                result += 1;
                height -= 1;
            }
        }
        return result;
    }

    /* 강의 풀이 */
    public static int solution(String str) {
        int count = 0;
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '(') { // 맨 위 쇠막대기의 시작부분
                stack.push('('); // 쇠막대기 추가
            } else {
                stack.pop();
                if (str.charAt(i - 1) == '(') { // 레이저부분
                    count += stack.size(); // 쌓은 쇠막대기 개수만큼 추가
                } else count++; // 맨 위 쇠막대기의 끝부분
            }
        }
        return count;
    }
}
