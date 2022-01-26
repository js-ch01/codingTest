package inflearn.javaCodingTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q5_07교육과정_설계 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String essential = scanner.next();
        String input = scanner.next();

        String result1 = validate1(essential, input);
//        System.out.println(result1);
        String result2 = validate2(essential, input);
        System.out.println(result2);
    }

    private static String validate1(String essential, String input) {
        // 필수과목이 아닌면 제거
        String str = input.replaceAll("[^" + essential + "]", "");
        return essential.equals(str)
                ? "YES"
                : "NO";
    }

    private static String validate2(String essential, String input) {
        int index = 0;
        for (char ch : essential.toCharArray()) {
            index = input.indexOf(ch, index); // 이전 필수과목 위치부터 찾기
            if (index < 0) {
                return "NO";
            }
        }

        return "YES";
    }

    /* 강의 풀이 */
    public static String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> Q = new LinkedList<>();
        for (char x : need.toCharArray()) Q.offer(x);
        for (char x : plan.toCharArray()) {
            if (Q.contains(x)) {
                if (x != Q.poll()) return "NO";
            }
        }
        if (!Q.isEmpty()) return "NO";
        return answer;
    }
}
