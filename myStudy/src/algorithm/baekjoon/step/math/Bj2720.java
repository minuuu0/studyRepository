package algorithm.baekjoon.step.math;

import java.util.Scanner;

public class Bj2720 {
    static final Scanner sc = new Scanner(System.in);

    static final StringBuilder sb = new StringBuilder();
    private static void testCase() {
        int money = sc.nextInt(); // 손님이 낸 돈 (센트)


        sb.append(money / 25 + " ");
        money %= 25;

        sb.append(money / 10 + " ");
        money %= 10;

        sb.append(money / 5 + " ");
        money %= 5;

        sb.append(money / 1 + " ");
        money %= 1;

    }

    public static void main(String[] args) {

        int caseSize = sc.nextInt();

        for (int caseIndex = 0; caseIndex < caseSize; caseIndex++) {
            testCase();
            sb.append('\n');
        }
        System.out.println(sb);
    }
}
