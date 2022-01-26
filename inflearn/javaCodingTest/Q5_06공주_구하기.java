package inflearn.javaCodingTest;

import java.util.*;

public class Q5_06공주_구하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int result = getPrinceNumber(n, k);
        System.out.println(result);
    }

    private static int getPrinceNumber(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(i + 1);

        int index = 0;
        for (int i = 0; i < n - 1; i++) {
            index = (index + k - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    /* 강의 풀이 */
    public static int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> Q = new LinkedList<>();
        for (int i = 1; i <= n; i++) Q.offer(i);
        while (!Q.isEmpty()) {
            for (int i = 1; i < k; i++) Q.offer(Q.poll());
            Q.poll();
            if (Q.size() == 1) answer = Q.poll();
        }
        return answer;
    }
}