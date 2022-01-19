package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Q2_02VisibleStudent {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int[] inputs = new int[num];
        for (int i = 0; i < num; i++) {
            inputs[i] = scanner.nextInt();
        }
//        int[] inputs = Arrays.stream("130 135 148 140 145 150 150 153".split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
        int result = getVisibleStudentNumber(inputs);
        System.out.println(result);
    }

    private static int getVisibleStudentNumber(int[] inputs) {
        // 맨 앞 한 명은 무조건 보임
        int count = 1;
        int maxHeight = inputs[0];

        for(int i= 1; i < inputs.length;i++) {
            if (inputs[i] > maxHeight) {
                maxHeight = inputs[i];
                count++;
            }
        }

        return count;
    }
}
