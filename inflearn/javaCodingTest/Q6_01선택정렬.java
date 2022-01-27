package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q6_01선택정렬 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        for (int i = 0; i < num; i++) nums[i] = scanner.nextInt();
        selectionSortAndPrint(nums);
    }

    private static void selectionSortAndPrint(int[] nums) {
        // i: i~(n-1)에서 최소값을 찾아서 i값과 교환
        for (int i = 0; i < nums.length - 1; i++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int j = i; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            int temp = nums[minIndex];
            nums[minIndex] = nums[i];
            nums[i] = temp;
        }
        for (int num : nums) System.out.print(num + " ");
    }

    /* 강의 풀이 */
    public static int[] solution(int n, int[] arr) {
        for (int i = 0; i < n - 1; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) idx = j;
            }
            int tmp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = tmp;
        }
        return arr;
    }
}
