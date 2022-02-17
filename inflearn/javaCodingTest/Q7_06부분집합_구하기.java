package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Q7_06부분집합_구하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        subset = new int[num + 1];
        printSubSet(1, num);
    }

    static int[] subset;

    /* 강의 풀이 수정*/
    private static void printSubSet(int level, int num) {
//        System.out.print("level = " + level);
//        System.out.println(", ch = " + Arrays.toString(ch));
        if (level == num + 1) {
            String tmp = "";
            for (int i = 1; i <= num; i++) {
                if (subset[i] == 1) tmp += (i + " ");
            }
            if (tmp.length() > 0) System.out.println(tmp);
        } else {
            subset[level] = 1;
            printSubSet(level + 1, num);
            subset[level] = 0;
            printSubSet(level + 1, num);
        }
    }
}
