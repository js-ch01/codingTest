package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q6_02버블정렬 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
        bubbleSortAndPrint(n, nums);
    }

    private static void bubbleSortAndPrint(int n, int[] nums) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
        for (int num : nums) System.out.print(num + " ");
    }
}
