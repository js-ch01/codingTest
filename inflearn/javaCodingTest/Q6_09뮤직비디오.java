package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_09뮤직비디오 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = scanner.nextInt();

        int result = solution(n, m, nums);
        System.out.println(result);
    }

    /* 강의 풀이 */
    public static int count(int[] arr, int capacity) {
        int count = 1, sum = 0;
        for (int x : arr) {
            if (sum + x > capacity) { // DVD용량 초과
                count++;   // DVD 개수늘리고
                sum = x; // 새 DVD에 넣기
            } else sum += x; // 현재 DVD에 추가
        }
        return count;
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt();
        int rt = Arrays.stream(arr).sum(); // 용량크기의 최대값
        while (lt <= rt) { // 이진탐색
            int mid = (lt + rt) / 2;
            if (count(arr, mid) <= m) { // m과 일치하는 경우에도 범위를 좁혀나간다
                answer = mid;
                rt = mid - 1;
            } else lt = mid + 1;
//            System.out.printf("lt=%-3d rt=%-5d mid=%-5d count(arr,mid)=%-3d answer=%-5d\n",
//                    lt, rt, mid, count(arr, mid), answer);
        }
        return answer;
    }
}
