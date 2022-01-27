package inflearn.javaCodingTest;

import java.util.Arrays;
import java.util.Scanner;

public class Q6_07좌표정렬 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Point[] points = new Point[n];
        for (int i = 0; i < n; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }
        sortAndPrint(points);
    }

    public static class Point implements Comparable<Point> {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (x == o.x) {
                if (y == o.y) return 0;
                else return y - o.y;
            } else {
                return x - o.x;
            }
        }

        @Override
        public String toString() {
            return x + " " + y;
        }
    }

    private static void sortAndPrint(Point[] points) {
        Arrays.sort(points);
        for (Point point : points) System.out.println(point);
    }
}
