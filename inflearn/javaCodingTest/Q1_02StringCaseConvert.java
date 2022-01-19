package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q1_02StringCaseConvert {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        String result = convert(str);
        System.out.println(result);
    }

    private static String convert(String str) {
        String converted = "";
        for (char ch : str.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                converted += Character.toLowerCase(ch);
            } else {
                converted += Character.toUpperCase(ch);
            }
        }

        return converted;
    }
}
