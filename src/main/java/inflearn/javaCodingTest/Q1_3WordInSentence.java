package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Q1_3WordInSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String result = longestWord(input);
        String result2 = longestWordByStream(input);
        System.out.println(result);
        System.out.println(result2);
    }

    private static String longestWord(String input) {
        String[] words = input.split(" ");
        String result = "";
        int longestLength = 0;
        for (String word : words) {
            if (word.length() > longestLength) {
                longestLength = word.length();
                result = word;
            }
        }
        return result;
    }

    private static String longestWordByStream(String input) {
        return Arrays.stream(input.split(" "))
                .max((s1, s2) -> s1.length() - s2.length())
//                .orElse("");
                .get();
    }
}
