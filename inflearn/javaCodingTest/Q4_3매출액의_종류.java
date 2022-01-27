package inflearn.javaCodingTest;

import java.util.*;

public class Q4_3매출액의_종류 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] sales = new int[n];
        for (int i = 0; i < n; i++) {
            sales[i] = scanner.nextInt();
        }

        getTypes(n, k, sales).forEach(num -> System.out.print(num + " "));
    }

    private static ArrayList<Integer> getTypes(int n, int k, int[] sales) {
        ArrayList<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (i < k) { // 초기값 넣기
                map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);
                if (i == k - 1) list.add(map.size());
                continue;
            }
            // 다음 값 추가
            map.put(sales[i], map.getOrDefault(sales[i], 0) + 1);

            // 구간의 맨 앞 빼기
            int temp = map.getOrDefault(sales[i - k], 0) - 1;
            if (temp <= 0) {
                map.remove(sales[i - k]); // 개수가 0이하면 제거
            } else {
                map.put(sales[i - k], temp);
            }
            // 맵의 크기 저장
            list.add(map.size());
        }
        return list;
    }

}
