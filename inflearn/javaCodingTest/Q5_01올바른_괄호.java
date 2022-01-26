package inflearn.javaCodingTest;

import java.util.Scanner;
import java.util.Stack;

public class Q5_01올바른_괄호 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        String result = validate(input);
        System.out.println(result);
    }

    private static String validate(String input) {
        Stack<Character> stack = new Stack<>();

        for(char ch : input.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if(stack.isEmpty()) return "NO";
                stack.pop();
            }
        }

        return stack.isEmpty()
                ?   "YES"
                :   "NO";
    }
}
