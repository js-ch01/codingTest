package inflearn.javaCodingTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q7_08송아지찾기_BFS {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        int E = scanner.nextInt();
        int result = getMinJump(S, E);
        System.out.println(result);
        System.out.println(BFS(S, E));
    }

    static int[] moves = {1, -1, 5};

    private static int getMinJump(int s, int e) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        int levelSize = 1;
        int indexInLevel = 0;
        int count = 0;

        while (!queue.isEmpty()) {
//            System.out.println(queue);
            Integer start = queue.poll();
            indexInLevel++;
            for (int i = 0; i < moves.length; i++) {
                int moved = start + moves[i];
                if (moved == e) return count + 1;
                else if (1 <= moved && moved <= 10000 && !queue.contains(moved)) {
                    queue.offer(moved);
                }
            }
            if (indexInLevel == levelSize) {
                levelSize = queue.size();
                count++;
                indexInLevel = 0;
            }
//            System.out.println("indexInLevel = " + indexInLevel);
//            System.out.println("levelSize = " + levelSize);
//            System.out.println("count = " + count);
        }

        return -1;
    }

    /* 강의 풀이 수정 */
//    static int[] moves = {1, -1, 5};
    // 해당위치에서 한번의 점프로 목표에 도달할 수 있는지 여부저장(Memoization)
    static int[] mem = new int[10001];

    public static int BFS(int s, int e) {
        Queue<Integer> Q = new LinkedList<>();
        Q.offer(s);
        mem[s] = 1;
        int level = 0;

        while (!Q.isEmpty()) {
            int len = Q.size();
            for (int i = 0; i < len; i++) {
                int x = Q.poll(); // 현재레벨에서 하나씩 poll
                for (int j = 0; j < 3; j++) { // 세 방향에 대해
                    int nx = x + moves[j];
                    if (nx == e) { // 도착
                        return level + 1;
                    }
                    // mem을 이용하여 이미 확인했었는지 확인
                    if (nx >= 1 && nx <= 10000 && mem[nx] == 0) {
                        mem[nx] = 1;
                        Q.offer(nx);
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
