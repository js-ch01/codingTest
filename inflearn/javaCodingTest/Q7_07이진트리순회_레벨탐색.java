package inflearn.javaCodingTest;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Q7_07이진트리순회_레벨탐색 {
    public static Node root;
    public static Queue<Node> queue = new LinkedList<>();

    public static void main(String[] args) {
        root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        queue.add(root);
        levelSearch();
//        DFS(root);
    }

    private static void levelSearch() {
        Node node = queue.poll();
        System.out.print(node.data + " ");
        if (node.lt != null) queue.offer(node.lt);
        if (node.rt != null) queue.offer(node.rt);

        if (queue.size() == 0) return;
        else levelSearch();
    }

    /* 강의 풀이 */
    public static void DFS(Node root) {
        Queue<Node> Q = new LinkedList<>();
        Q.add(root);
        int L = 0;
        while (!Q.isEmpty()) {
            int len = Q.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = Q.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) Q.add(cur.lt);
                if (cur.rt != null) Q.add(cur.rt);
            }
            L++;
            System.out.println();
        }
    }

    public static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }
}
