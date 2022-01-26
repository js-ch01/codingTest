package inflearn.javaCodingTest;

import java.util.*;

public class Q5_08응급실 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] inputs = new int[n];
        for (int i = 0; i < n; i++) inputs[i] = scanner.nextInt();

        int result = getWaitingOrder(m, inputs);
        System.out.println(result);
    }

    private static int getWaitingOrder(int m, int[] inputs) {
        int count = 0;
        // m번째 환자의 위험도, 비교하기위해 새 인스턴스생성
        Integer risk_m = new Integer(inputs[m]);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inputs.length; i++) {
            if (i == m) queue.offer(risk_m);
            else queue.offer(inputs[i]);
        }

        while (!queue.isEmpty()) {
            // 최대값의 인덱스를 구한다
            int maxIndex = -1;
            int max = -1;
            Integer temp = 0;
            for (int i = 0; i < queue.size(); i++) {
                temp = queue.poll();
                if (max < temp) {
                    max = temp;
                    maxIndex = i;
                }
                queue.offer(temp);
            }
            // 최대값 전까지 poll하고 offer
            for (int i = 0; i < maxIndex; i++) {
                queue.offer(queue.poll());
            }
            temp = queue.poll(); // 최대값
            count++;
            if (temp == risk_m) break; // 인스턴스 주소값 비교
        }

        return count;
    }

    /* 강의 풀이 */
    static class Person {
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> Q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            Q.offer(new Person(i, arr[i]));
        }
        while (!Q.isEmpty()) {
            Person tmp = Q.poll();
            for (Person x : Q) {
                // tmp가 최대값이 아니면 다시 맨 뒤에 offer하고 null로 초기화
                if (x.priority > tmp.priority) {
                    Q.offer(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) { // tmp가 최대값
                answer++;
                if (tmp.id == m) return answer;
            }
        }
        return answer;
    }
}
// Integer.valueOf(int), 오토박싱은 -127~128까지 캐싱(상수풀)