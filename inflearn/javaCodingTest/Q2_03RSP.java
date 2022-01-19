package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Q2_03RSP {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] rsp_A = new int[num];
        int[] rsp_B = new int[num];
        for (int i = 0; i < num; i++) {
            rsp_A[i] = scanner.nextInt();
        }
        for (int i = 0; i < num; i++) {
            rsp_B[i] = scanner.nextInt();
        }
        checkRSPResult(num, rsp_A, rsp_B);
    }

    private static void checkRSPResult(int num, int[] rsp_A, int[] rsp_B) {
        for(int i = 0; i < num; i++) {
            switch (rsp_A[i] - rsp_B[i]) {
                case 1:
                case -2:
                    System.out.println("A");
                    break;
                case -1:
                case 2:
                    System.out.println("B");
                    break;
                case 0:
                    System.out.println("D");
                    break;
            }
        }
    }
}
/*
가위 바위 1 2    -1 B
바위 보   2 3    -1 B
보 가위   3 1     2 B

바위 가위 2 1   1  A
보 바위   3 2   1  A
가위 보   1 3   -2 A
 */


