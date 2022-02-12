package inflearn.javaCodingTest;

public class Q7_05이진트리순회 {
    public static void main(String[] args) {
        Node root = new Node(1);
        root.lt = new Node(2);
        root.rt = new Node(3);
        root.lt.lt = new Node(4);
        root.lt.rt = new Node(5);
        root.rt.lt = new Node(6);
        root.rt.rt = new Node(7);
        System.out.println("preOrder:");
        preOrder(root);
        System.out.println();
        System.out.println("inOrder:");
        inOrder(root);
        System.out.println();
        System.out.println("postOrder:");
        postOrder(root);
        System.out.println();
    }

    private static void preOrder(Node root) {
        if(root != null) System.out.print(root.data + " ");
        if(root.lt != null) preOrder(root.lt);
        if(root.rt != null) preOrder(root.rt);
    }

    private static void inOrder(Node root) {
        if(root.lt != null) inOrder(root.lt);
        System.out.print(root.data + " ");
        if(root.rt != null) inOrder(root.rt);
    }

    private static void postOrder(Node root) {
        if(root.lt != null) postOrder(root.lt);
        if(root.rt != null) postOrder(root.rt);
        System.out.print(root.data + " ");
    }

    static class Node {
        int data;
        Node lt, rt;

        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }
}
