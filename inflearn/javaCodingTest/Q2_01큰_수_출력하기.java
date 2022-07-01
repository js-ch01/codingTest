package inflearn.javaCodingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q2_01큰_수_출력하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.nextLine(); // '\n'처리
        String input = scanner.nextLine();
//        int num = 6;
//        String input = "7 3 9 5 6 12";
        bigNum(num, input);
    }

    private static void bigNum(int num, String input) {
        int[] nums = Arrays.stream(input.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.print(nums[0] + " ");
        for(int i = 1; i < num; i++) {
            if (nums[i-1] < nums[i]) {
                System.out.print(nums[i] + " ");
            }
        }
    }

    private static Integer[] print(int num, int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < num; i++) {
            if(nums[i-1] < nums[i]) list.add(nums[i]);
        }

        return list.toArray(Integer[]::new);
    }

    private static int[] print2(int num, int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for(int i = 1; i < num; i++) {
            if(nums[i-1] < nums[i]) list.add(nums[i]);
        }

        return list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
