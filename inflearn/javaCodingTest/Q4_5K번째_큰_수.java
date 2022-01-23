package inflearn.javaCodingTest;

import java.util.*;

public class Q4_5K번째_큰_수 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }
        int result = getKth(n, k, nums);
        System.out.println(result);
    }

    private static int getKth(int n, int k, int[] nums) {
        //모든 경우의 수 저장 (중복제거, 내림차순)
        TreeSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                for (int l = j + 1; l < n; l++)
                    set.add(nums[i] + nums[j] + nums[l]);

        // k번째 값 반환
        return set.stream().skip(k - 1).findFirst().orElse(-1);
    }
}
