package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q1_5ReverseSpecificString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
        String input = "a#b!GE*T@S\n";
        reverse(input);
    }

    private static void reverse(String input) {
        int left = 0;
        int right = input.length()-1;
        char[] chars = input.toCharArray();
        while (left < right) {
            if(Character.isAlphabetic(chars[left]) && Character.isAlphabetic(chars[right])) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;
                left++;
                right--;
                continue;
            }
            if (!Character.isAlphabetic(chars[left])) {
                left++;
            }
            if (!Character.isAlphabetic(chars[right])) {
                right--;
            }
        }
        System.out.println(chars);
    }
}
