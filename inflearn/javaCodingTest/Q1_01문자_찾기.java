package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q1_01문자_찾기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine().toLowerCase();
        char ch = scanner.nextLine().toLowerCase().charAt(0);

        int result = stringSearchByLoop(str, ch);
        int result2 = stringSearchByLoop2(str, ch);
        int result3 = stringSearchByStream(str, ch);
        System.out.println(result);
//        System.out.println("result2 = " + result2);
//        System.out.println("result3 = " + result3);
    }

    private static int stringSearchByLoop(String str, char ch) {
        int result = 0;
        int index = 0;
        while(str.indexOf(ch, index) >= 0) {
            index = str.indexOf(ch, index) + 1;
            result++;
        }
        return result;
    }

    private static int stringSearchByLoop2(String str, char ch) {
        int result = 0;
        for (char c : str.toCharArray()) {
            if (c == ch) result++;
        }

        return result;
    }

    private static int stringSearchByStream(String str, char ch) {
        return (int) str.chars().filter(c -> c == ch).count();
    }
}
