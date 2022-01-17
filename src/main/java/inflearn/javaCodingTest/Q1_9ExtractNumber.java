package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q1_9ExtractNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
        String input = "g0en2T0s8eSoft";
        int result1 = extractNumber1(input);
        int result2 = extractNumber2(input);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(Character.getNumericValue(50));
        System.out.println(Character.getNumericValue('@'));
    }

    private static int extractNumber1(String input) {
        int result = 0;
        for (char ch : input.toCharArray()) {
            if (Character.isDigit(ch)) {
                result *= 10;
                result += ch - '0'; // 숫자(char)를 int로
            }
        }

        return result;
    }

    private static int extractNumber2(String input) {
        StringBuilder sb = new StringBuilder();
        input.chars()
                .filter(Character::isDigit)
                .forEach(sb::appendCodePoint);
        return Integer.parseInt(sb.toString());
    }
}
// parseInt vs valueOf
// ch - '0' 숫자(char)를 int로 바꾸기 (Integer.parseInt(ch+"");)
