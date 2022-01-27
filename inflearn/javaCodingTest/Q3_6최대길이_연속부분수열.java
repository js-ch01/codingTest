package inflearn.javaCodingTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q3_6최대길이_연속부분수열 {
    static int _num = 14;
    static int _k = 2;
    static int[] _nums = {1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] nums = new int[num];
        int k = scanner.nextInt();
        for (int i = 0; i < num; i++) nums[i] = scanner.nextInt();

        int result = getLongest(num, k, nums);
//        int result = getLongest(_num, _k, _nums);
        System.out.println(result);
    }

    private static int getLongest(int num, int k, int[] nums) {
        // 0의 위치의 인덱스들을 갖는 List
        List<Integer> indicesOfZero = new ArrayList<>();
        indicesOfZero.add(-1); // 맨 처음 앞은 0으로 계산
        for (int i = 0; i < num; i++) {
            if (nums[i] == 0) indicesOfZero.add(i);
        }
        indicesOfZero.add(num); // 맨 마지막 뒤는 0으로 계산
//        System.out.println(indicesOfZero);

        int max = 0;
        for (int i = 0; i < indicesOfZero.size() - (k + 1); i++) {
//            System.out.printf("1st zero:%d ~ 4th zero:%d\n", i, i + k + 1);
//            System.out.printf("indices[%d]:%d ~ indices[%d]:%d\n\n", i, indicesOfZero.get(i), i + k + 1, indicesOfZero.get(i + k + 1));
            // 0...0...0...0
            // 첫 0부터 (그 다음 (k+1)번쨰 0의 위치-1)이 최대연속길이
            int firstZeroIndex = indicesOfZero.get(i);
            int forthZeroIndex = indicesOfZero.get(i + (k + 1));
            int length = (forthZeroIndex -1) - firstZeroIndex;
            max = Math.max(max, length);
        }

        return max;
    }

    /* 강의 풀이 */
    public static int solution(int n, int k, int[] arr) {
        int max = 0, numOfZero = 0, start = 0;
        for (int end = 0; end < n; end++) {
            // 오른쪽에서 0을 만났는데 k개 초과면 왼쪽에서 0을 뺀다
            if (arr[end] == 0) numOfZero++;
            while (numOfZero > k) {
                if (arr[start] == 0) numOfZero--;
                start++;
            }

            // 최대길이는 매번 확인한다 (맨 처음 앞과 맨 마지막 뒤 신경안써도 됨)
            max = Math.max(max, end - start + 1);
        }
        return max;
    }
}