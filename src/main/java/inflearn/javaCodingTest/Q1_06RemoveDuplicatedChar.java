package inflearn.javaCodingTest;

import java.util.*;

public class Q1_06RemoveDuplicatedChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        String result1 = removeDuplicate1(input);
        String result2 = removeDuplicate2(input);
        String result3 = removeDuplicate3(input);
        System.out.println(result1);
        System.out.println(result2);
        System.out.println(result3);
    }


    private static String removeDuplicate1(String input) {
        Set<Character> set = new LinkedHashSet<>();
        for (char ch : input.toCharArray()) {
            set.add(ch);
        }
        StringBuilder result = new StringBuilder();
        set.stream().forEach(result::append);
        return result.toString();
    }

    private static String removeDuplicate2(String input) {
        StringBuilder result = new StringBuilder();
        input.chars()
                .distinct()
                .mapToObj(c -> (char) c)
                .forEach(result::append);
        input.chars()
                .distinct()
                .forEach(result::appendCodePoint);

        return result.toString();
    }

    private static String removeDuplicate3(String input) {
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (result.indexOf(ch + "") < 0) {
                result.append(ch);
            }
        }

        return result.toString();
    }
}
