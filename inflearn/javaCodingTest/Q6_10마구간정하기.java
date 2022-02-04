package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_10마구간정하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int c = scanner.nextInt();
        int[] pos = new int[n];
        for (int i = 0; i < n; i++) pos[i] = scanner.nextInt();

        int result = getMaxDist(n, c, pos);
        System.out.println(result);
    }

    private static int getMaxDist(int n, int c, int[] pos) {
        Arrays.sort(pos);
        int result = 0;
        int left = 1;
        int right = pos[n - 1] - pos[0];

        while (left <= right) {
            int mid = (left + right) / 2;
            if (countHorse(pos, mid) >= c) {
                left = mid + 1;
                result = mid;
            } else {
                right = mid - 1;
            }
            System.out.printf("lt=%-3d rt=%-6d mid=%-6d count(arr,mid)=%-4d answer=%-6d\n",
                    left, right, mid, countHorse(pos, mid), result);
        }
        return result;
    }

    private static int countHorse(int[] pos, int maxDist) {
        int count = 1;
        int current = pos[0];
        for (int i = 1; i < pos.length; i++) {
            if (pos[i] - current >= maxDist) {
                count++;
                current = pos[i];
            }
        }
        return count;
    }

    /* 강의 풀이 */
    public static int count(int[] arr, int dist) {
        int count = 1;
        int ep = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - ep >= dist) {
                count++;
                ep = arr[i];
            }
        }
        return count;
    }

    public static int solution(int n, int c, int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        int lt = 1;
        int rt = arr[n - 1];
        while (lt <= rt) {
            int mid = (lt + rt) / 2;
            if (count(arr, mid) >= c) {
                answer = mid;
                lt = mid + 1;
            } else rt = mid - 1;
        }
        return answer;
    }
}