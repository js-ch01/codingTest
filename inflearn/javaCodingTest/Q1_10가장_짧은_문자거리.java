package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q1_10가장_짧은_문자거리 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        char ch = scanner.next().charAt(0);
        shortestCharDist(input, ch);
//        shortestCharDist("teachermode", 'e');
    }

private static void shortestCharDist(String input, char ch) {
    for (int i = 0; i < input.length(); i++) {
        int left = input.substring(0, i).lastIndexOf(ch);
        // i의 왼쪽에서 마지막으로 같은문자의 인덱스
        int right = input.indexOf(ch, i);
        // i포함 오른쪽에서 첫번째로 같은문자의 인덱스
        left = left == -1 ? Integer.MAX_VALUE : left; // 못 찾은경우 가장 먼 값
        right = right == -1 ? Integer.MAX_VALUE : right; // 못 찾은경우 가장 먼 값

//            System.out.println("\n\ni: " + i);
//            System.out.println("left:" + left);
//            System.out.println("right:" + right);
//            System.out.print("result: ");
        int result = Math.min(Math.abs(i - left), Math.abs(i - right));
        // left와의 차이와 right와의 차이중에서 작은값을 선택
        System.out.print(result + " ");
    }
}
}
