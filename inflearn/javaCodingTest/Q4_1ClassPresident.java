package inflearn.javaCodingTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q4_1ClassPresident {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        String input = scanner.next();

        char result1 = getClassPresident1(num, input);
        System.out.println(result1);
        char result2 = getClassPresident2(num, input);
        System.out.println(result2);

    }

    private static char getClassPresident1(int num, String input) {
        int[] nums = new int[5];
        for (char ch : input.toCharArray()) {
            nums[ch - 'A']++; // nums[0]은 A의 개수, nums[1]은 B의 개수..
        }

        int maxIndex = -1;
        int max = 0;
        for (int i = 0; i < 5; i++) {
            if (max < nums[i]) {
                max = nums[i];
                maxIndex = i;
            }
        }
        return (char) (maxIndex + 'A');
    }

    private static char getClassPresident2(int num, String input) {
        Map<Character, Integer> map = new HashMap<>();
        for(char ch : input.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map.keySet().stream() // key스트림
                // key 최대값의 기준을 value로
                .max((k1, k2) -> map.get(k1) - map.get(k2))
                .orElse('F');
    }
}
