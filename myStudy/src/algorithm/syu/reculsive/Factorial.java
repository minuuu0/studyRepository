package algorithm.syu.reculsive;

import java.util.Scanner;

public class Factorial {
    static final Scanner sc = new Scanner(System.in);
    private static int getFactorial(int n) {
        if(n == 1) return 1; // baseCase 베이스 케이스
        return n * getFactorial(n - 1); // reculsion 재귀 케이스
    }

    public static void main(String[] args) {
        int n = sc.nextInt();

        int answer = getFactorial(n);
        System.out.println(answer);
    }
}
