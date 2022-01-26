package inflearn.javaCodingTest;

import java.util.Scanner;
import java.util.Stack;

public class Q5_04후위식_연산 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();

        int result = evaluatePostfix(input);
        System.out.println(result);
    }

    private static int evaluatePostfix(String input) {
        Stack<Integer> stack = new Stack<>();
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) stack.push(ch - '0');
            else {
                int num2 = stack.pop();
                int num1 = stack.pop();
                switch (ch) {
                    case '+':
                        stack.push(num1 + num2);
                        break;
                    case '-':
                        stack.push(num1 - num2);
                        break;
                    case '*':
                        stack.push(num1 * num2);
                        break;
                    case '/':
                        stack.push(num1 / num2);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
