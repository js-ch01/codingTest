package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q1_12암호 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String input = scanner.next();
//        int num = 4;
//        String input = "#****###**#####**#####**##**";
        String result = depress(num, input);
        System.out.println(result);
    }

private static String depress(int num, String input) {
    StringBuilder sb = new StringBuilder();
    String binaries = input.replace('#', '1').replace('*', '0');
    for (int i = 0; i < num; i++) {
        String binary = binaries.substring(i * 7, (i + 1) * 7);
        int ascii = Integer.parseInt(binary, 2);
        sb.appendCodePoint(ascii);
    }
    return sb.toString();
}
}
