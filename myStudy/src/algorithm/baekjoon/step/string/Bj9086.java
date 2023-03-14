package algorithm.baekjoon.step.string;

import java.util.Scanner;

public class Bj9086 {
    static final Scanner sc = new Scanner(System.in);
    private static void testCase() {
        String s = sc.next();
        System.out.printf("%s%s\n", s.charAt(0), s.charAt(s.length() - 1));
    }

    public static void main(String[] args) {
        int caseSize = sc.nextInt();
        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase();
        }
    }
}
