package inflearn.javaCodingTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q4_2Anagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str1 = scanner.next();
        String str2 = scanner.next();

//        String result1 = isAnagram("AbaAeCe", "baeeACA");
//        System.out.println(result1);

        String result = isAnagram(str1, str2);
        System.out.println(result);
    }

    private static String isAnagram(String str1, String str2) {
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : str1.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (char ch : str2.toCharArray()) {
            int temp = map.getOrDefault(ch, 0) - 1;
            if (temp == -1) return "NO";
            map.put(ch, temp);
        }

        return "YES";
    }
}
