package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q1_08유효한_팰린드롬 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
//        String input = "found7, time: study; Yduts; emit, 7Dnuof\n";
        String result1 = isPalindrome1(input);
        String result2 = isPalindrome2(input);
//        System.out.println(result1);
        System.out.println(result2);

        StringBuilder sb = new StringBuilder("ABC");
        System.out.println(sb.reverse()); // CBA
        System.out.println(sb);           // CBA
    }

    private static String isPalindrome1(String input) {
        char[] chars = input.toLowerCase().toCharArray();
        int left = 0;
        int right = input.length() - 1;

        // 양끝에서 출발하여 둘 다 문자일경우에만 같은지 비교
        while (left < right) {
            if (!Character.isLetter(chars[left])) {
                left++;
                continue;
            }
            if (!Character.isLetter(chars[right])) {
                right--;
                continue;
            }
            if (chars[left] != chars[right]) {
                return "NO";
            } else {
                left++;
                right--;
            }
        }
        return "YES";

    }

    private static String isPalindrome2(String input) {
        StringBuilder sb = new StringBuilder();
        input.chars()
                .filter(Character::isLetter)  // 알파벳만 필터링
                .forEach(sb::appendCodePoint); // StringBuilder에 추가
        String alphabet = sb.toString();
        String alphabet_reversed = sb.reverse().toString();
        // reverse()는 순수함수가 아니라서 값이 바뀌니 주의
        // codePoints를 받는 String 생성자
        return alphabet.equalsIgnoreCase(alphabet_reversed)
                ? "YES"
                : "NO";
    }

}
