package inflearn.javaCodingTest;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Q6_04LeastRecentlyUsed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int n = scanner.nextInt();
        int[] tasks = new int[n];
        for (int i = 0; i < n; i++) tasks[i] = scanner.nextInt();
        printMemory1(size, tasks);
    }

    private static void printMemory1(int size, int[] tasks) {
        ArrayDeque<Integer> cache = new ArrayDeque<>();
        for (int task : tasks) {
            if (cache.contains(task)) { // cache hit
                cache.remove(task);
            } else if (cache.size() >= size) { // cache miss
                cache.pollLast();
            }
            cache.offerFirst(task);
        }
        cache.forEach(num -> System.out.print(num + " "));
    }

    /* 강의 풀이 */
    public static int[] solution(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) {
                // cache에 값이 있는지 확인
                if (x == cache[i]) pos = i;
            }
            if (pos == -1) { // cache miss
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else { // cache hit
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            }
            cache[0] = x;
        }
        return cache;
    }
}
