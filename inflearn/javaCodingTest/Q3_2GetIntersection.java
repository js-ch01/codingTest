package inflearn.javaCodingTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Q3_2GetIntersection {
    static int _num1 = 5;
    static int _num2 = 5;
    static int[] _arr1 = {1, 3, 9, 5, 2};
    static int[] _arr2 = {3, 2, 5, 7, 8};


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

//        List<Integer> result = getIntersection(_num1, _num2, _arr1, _arr2);
//        result.forEach(n-> System.out.print(n + " "));
//        System.out.println();

        List<Integer> result = getIntersection(num1, num2, arr1, arr2);
        result.forEach(n -> System.out.print(n + " "));
        System.out.println();

        ArrayList<Integer> solution = solution(num1, num2, arr1, arr2);
        solution.forEach(n -> System.out.print(n + " "));
    }

    private static List<Integer> getIntersection(int num1, int num2, int[] arr1, int[] arr2) {
        ArrayList<Integer> result = new ArrayList<>();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < num1; i++) {
            for (int j = 0; j < num2; j++) {
                if (arr1[i] == arr2[j]) {
                    result.add(arr1[i]);
                    break;
                } else if (arr1[i] < arr2[j]) {
                    break;
                }
            }
        }

        return result;
    }

    /* 강의 풀이 */
    public static ArrayList<Integer> solution(int num1, int num2,
                                              int[] arr1, int[] arr2) {
        ArrayList<Integer> answer = new ArrayList<>();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int index1 = 0, index2 = 0;

        // 어느 한 배열이 끝에 도달하면 비교를 멈춘다
        while (index1 < num1 && index2 < num2) {
            if (arr1[index1] == arr2[index2]) {
                answer.add(arr1[index1]);
                index1++;
                index2++;
            } else if (arr1[index1] < arr2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }

        return answer;
    }
}