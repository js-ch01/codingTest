package inflearn.javaCodingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Q3_1CombineArray {
    static int[] _arr1 = {1, 3, 5};
    static int[] _arr2 = {2, 3, 6, 7, 9};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int[] arr1 = new int[num1];
        for (int i = 0; i < num1; i++) {
            arr1[i] = scanner.nextInt();
        }
        int num2 = scanner.nextInt();
        int[] arr2 = new int[num2];
        for (int i = 0; i < num2; i++) {
            arr2[i] = scanner.nextInt();
        }

//        combineArray1(_arr1, _arr2);
//        System.out.println();
//        combineArray2(_arr1, _arr2);
//        System.out.println();
        combineArray1(arr1, arr2);
        System.out.println();
        combineArray2(arr1, arr2);
        System.out.println();
        solution(num1, num2, arr1, arr2).forEach(n-> System.out.print(n + " "));
    }


    private static void combineArray1(int[] arr1, int[] arr2) {
        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (arr1[index1] < arr2[index2]) {
                System.out.print(arr1[index1++] + " ");
            } else {
                System.out.print(arr2[index2++] + " ");
            }
            if (index1 == arr1.length) { // arr1이 전부 출력되면
                for (int i = index2; i < arr2.length; i++) { // 남은 arr2를 전부 출력
                    System.out.print(arr2[i] + " ");
                }
                break;
            } else if (index2 == arr2.length) {
                for (int i = index1; i < arr1.length; i++) {
                    System.out.print(arr1[i] + " ");
                }
                break;
            }
        }
    }

    private static void combineArray2(int[] arr1, int[] arr2) {
        int[][] arrays = {arr1, arr2};
        Arrays.stream(arrays)
                .flatMapToInt(Arrays::stream)
                .sorted()
                .forEach(n -> System.out.print(n + " "));
    }

    /* 강의 풀이 */
    public static ArrayList<Integer> solution(int length1, int length2, int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        int index1 = 0, index2 = 0;

        while (index1 < length1 && index2 < length2) { // 한 배열이 다 출력되면 while문이 멈추게된다
            if (arr1[index1] < arr2[index2]) answer.add(arr1[index1++]);
            else answer.add(arr2[index2++]);
        }

        // 다 출력된 쪽은 while문이 실행안됨
        while (index1 < length1) answer.add(arr1[index1++]);
        while (index2 < length2) answer.add(arr2[index2++]);

        return answer;
    }
}
