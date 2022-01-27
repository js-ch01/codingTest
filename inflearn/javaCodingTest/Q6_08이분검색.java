package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_08이분검색 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();

        int result = getPosition(m, nums);
        System.out.println(result);
    }

    private static int getPosition(int m, int[] nums) {
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        int mid;

        while (left < right) {
            mid = (left + right) / 2;
            if (nums[mid] == m) return mid + 1;
            else if (nums[mid] > m) {
                right = mid;
            } else {
                left = mid;
            }
        }
// 1 2 3 4 5 6
        return -1;
    }
}
