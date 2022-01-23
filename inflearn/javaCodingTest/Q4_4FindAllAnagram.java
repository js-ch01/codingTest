package inflearn.javaCodingTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Q4_4FindAllAnagram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        String t = scanner.next();

        int result = findAllAnagram(s, t);
//        int result = findAllAnagram("bacaAacba", "abc");
        System.out.println(result);
    }

    private static int findAllAnagram(String s, String t) {
        int count = 0;
        Map<Character, Integer> map_s = new HashMap<>();
        Map<Character, Integer> map_t = new HashMap<>();
        for (char ch : t.toCharArray()) {
            map_t.put(ch, map_t.getOrDefault(ch, 0) + 1);
        }

        for (int i = 0; i <= t.length() - 1; i++) {
            map_s.put(s.charAt(i), map_s.getOrDefault(s.charAt(i), 0) + 1);
            if (map_s.equals(map_t)) count++;
        }

        for (int i = t.length(); i < s.length(); i++) {
            char firstIndex = s.charAt(i - t.length());
            map_s.put(s.charAt(i), map_s.getOrDefault(s.charAt(i), 0) + 1);
            map_s.put(firstIndex, map_s.getOrDefault(firstIndex, 0) - 1);
            if (map_s.get(firstIndex) == 0) map_s.remove(firstIndex);
            if (map_s.equals(map_t)) count++;
        }

        return count;
    }
}
