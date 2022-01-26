package inflearn.javaCodingTest;

import java.util.Scanner;
import java.util.Stack;

public class Q5_02괄호문자제거 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        String result1 = removeParentheses1(input);
        System.out.println(result1);
        String result2 = removeParentheses2(input);
        System.out.println(result2);
    }

    private static String removeParentheses1(String input) {
        StringBuilder result = new StringBuilder();
        int count = 0; // 괄호의 개수를 저장

        for (char ch : input.toCharArray()) {
            if (ch == '(') count++;
            else if (ch == ')') count--;
                // 현재 괄호가 없는 경우에만 저장
            else if (count == 0) result.append(ch);
        }

        return result.toString();
    }

    private static String removeParentheses2(String input) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (ch == '(') stack.push(ch);
            else if (ch == ')') stack.pop();
            else if (stack.isEmpty()) result.append(ch);
        }

        return result.toString();
    }
}
