package algorithm.baekjoon.class2;

import java.util.Scanner;


public class Bj2292 {
    public static final Scanner sc = new Scanner(System.in);
    private static int getMinRoom(int n) {
        if (n == 1) return 1;

        int cnt = 1;

        int range = 2;
        while (range <= n){
            range += 6 * cnt;
            cnt++;
        }
        return  cnt;

    }
    public static void main(String[] args) {
        int n = sc.nextInt();

        int answer = getMinRoom(n);
        System.out.println(answer);
    }
}
