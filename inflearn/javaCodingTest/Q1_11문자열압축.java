package inflearn.javaCodingTest;

import java.util.Scanner;

public class Q1_11문자열압축 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String input = scanner.next();
        String input = "KSTTTSEEKFKKKDJJGG";
        String result = compressStr1(input);
        System.out.println(result);
    }

    private static String compressStr1(String input) {
        StringBuilder sb = new StringBuilder();
        char[] chars = input.toCharArray();

        // 첫 문자로 초기화
        char preChar = chars[0];
        int count = 1;

        // 인덱스1부터(두번쨰 문자) 시작
        for (int i = 1; i < chars.length; i++) {
            if (preChar != chars[i]) { // 다른 문자가 나오면
                sb.append(preChar);    // 결과에 기존문자 추가
                if (count != 1) sb.append(count); // 반복횟수가 1인 경우 생략
                preChar = chars[i];    // 새 문자로 초기화
                count = 1;             // 1로 초기화
            } else {
                count++;
            }
        }
        // 마지막 남은 압축 추가
        sb.append(preChar);
        if (count != 1) sb.append(count);

        return sb.toString();
    }

    // 강의풀이
    public String solution(String s) {
        String answer = "";
        s = s + " "; // 마지막 문자 비교를 위해
        int cnt = 1;
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) cnt++; // 다음문자와 비교
            else {
                answer += s.charAt(i);
                if (cnt > 1) answer += String.valueOf(cnt);
                cnt = 1;
            }
        }
        return answer;
    }
}
