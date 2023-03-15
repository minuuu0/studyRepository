package algorithm.baekjoon.step.string;

import java.util.Scanner;

public class Bj2675 {
    static final Scanner sc = new Scanner(System.in);
    private static void testcase() {
        int r = sc.nextInt(); // 반복횟수 r
        String s = sc.next(); // 반복할 문자

        for(int i = 0; i < s.length(); i++){ // 모든문자에 대해서
            for(int j = 0; j < r; j++){
                System.out.print(s.charAt(i));
            }
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int caseSize = sc.nextInt();

        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testcase();
        }
    }
}
