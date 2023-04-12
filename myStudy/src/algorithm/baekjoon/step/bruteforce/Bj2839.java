package algorithm.baekjoon.step.bruteforce;

import java.util.Scanner;

public class Bj2839 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        int n = sc.nextInt();

        if(n == 4 || n == 7){
            System.out.println(-1);
        } else if (n % 5 == 0) { // n이 나누어 떨어지면
            System.out.println(n / 5);
        } else if (n % 5 == 1 || n % 5 == 3) {
            System.out.println(n / 5 + 1);
        } else if (n % 5 == 2 || n % 5 == 4) {
            System.out.println(n / 5 + 2);
        }
    }
}
