package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q1_7Palindrome {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
//        String input = "gooG";
        Object temp = new Object();
        String result1 = isPalindrome1(input);
        String result2 = isPalindrome2(input);
        System.out.println(result1);
        System.out.println(result2);
    }


    private static String isPalindrome1(String input) {
        // 대소문자 구별하지 않기 위해 toLowerCase()
        char[] chars = input.toLowerCase().toCharArray();
        // 서로 대칭되는지 확인
        for (int i = 0; i < chars.length / 2; i++) {
            if (chars[i] != chars[chars.length - 1 - i]) {
                return "NO";
            }
        }
        return "YES";
    }

private static String isPalindrome2(String input) {
    return input.equalsIgnoreCase(new StringBuilder(input).reverse().toString())
            ? "YES"
            : "NO";
}
}
