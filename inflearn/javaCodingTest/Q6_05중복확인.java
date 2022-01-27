package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_05중복확인 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();
        char result = isDuplicated(n, nums);
        System.out.println(result);
    }

    private static char isDuplicated(int n, int[] nums) {
        return Arrays.stream(nums).distinct().count() == n
                ? 'U'
                : 'D';
    }
}
