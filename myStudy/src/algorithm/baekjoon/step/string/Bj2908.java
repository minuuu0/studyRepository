package algorithm.baekjoon.step.string;

import java.util.Scanner;

public class Bj2908 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int a = Integer.parseInt(new StringBuilder().append(sc.nextInt()).reverse().toString());
        int b = Integer.parseInt(new StringBuilder().append(sc.nextInt()).reverse().toString());
        System.out.println(a > b ? a : b);
    }
}
