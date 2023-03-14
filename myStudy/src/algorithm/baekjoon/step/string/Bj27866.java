package algorithm.baekjoon.step.string;

import java.util.Scanner;

public class Bj27866 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String S = sc.next(); // 단어
        int i = sc.nextInt(); // 정수
        System.out.println(S.charAt(i - 1));
    }
}
