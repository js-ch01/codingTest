package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q6_03삽입정렬 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();

        insertionSortAndPrint(n, nums);
    }

    private static void insertionSortAndPrint(int n, int[] nums) {
        for (int i = 1; i < n; i++) {
            int temp = nums[i]; // 삽입할 숫자
            // 0 ~ (j-1)은 정렬되어 있으므로 (j-1)부터 0 까지 거꾸로 비교
            int j = i - 1;
            for (; j >= 0; j--) {
                if (nums[j] > temp) {
                    nums[j + 1] = nums[j]; // 삽입할 숫자보다 크면 오른쪽으로 옮긴다
                } else break; // j는 삽입할 숫자보다 작은 숫자의 위치를 갖게된다
            }
            nums[j + 1] = temp; // (j+1)이 삽입할 위치
        }
        for (int num : nums) System.out.print(num + " ");
    }
}
