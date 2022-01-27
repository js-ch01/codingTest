package inflearn.javaCodingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Q6_06장난꾸러기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) heights[i] = scanner.nextInt();

        printNumbers1(n, heights);
        printNumbers2(n, heights);
    }

    private static void printNumbers1(int n, int[] heights) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int height : heights) list.add(height);
        int idx_cheolSu = -1;
        int idx_partner = -1;

        // 뒤에서부터 짝꿍의 값을 탐색
        // 뒤부터 찾아야 짝꿍의 값이 중복일 경우를 피할 수 있다
        for (int i = n - 1; i > 0; i--) {
            if (list.get(i - 1) > list.get(i)) {
                idx_partner = i;
                break;
            }
        }

        // 짝꿍 키보다 처음으로 큰 키 위치가 철수키의 위치
        for (int i = 0; i < n; i++) {
            if(list.get(i) > list.get(idx_partner)) {
                idx_cheolSu = i;
                break;
            }
        }

        System.out.println((idx_cheolSu + 1) + " " + (idx_partner + 1));
    }

    private static void printNumbers2(int n, int[] heights) {
        int[] sorted = Arrays.copyOf(heights, n);
        Arrays.sort(sorted);

        for (int i = 0; i < n; i++) {
            if (heights[i] != sorted[i]) System.out.print((i+1) + " ");
        }
    }
}
