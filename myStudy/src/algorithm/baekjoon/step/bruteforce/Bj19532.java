package algorithm.baekjoon.step.bruteforce;

import java.util.Scanner;

public class Bj19532 {
    static final Scanner sc = new Scanner(System.in);
    private static void getAns(int a, int b, int c, int d, int e, int f) {
        boolean ab = false;
        for(int i = -999; i <= 999; i++){ // x값 탐색
            for(int j = -999; j <= 999; j++){ // y 탐색
                if(a * i + b * j == c && d * i + e * j == f){
                    System.out.println(i + " " + j);
                    ab = true;
                    break;
                    }
                }
            if(ab){
                break;
            }
            }
        }

    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        int e = sc.nextInt();
        int f = sc.nextInt();

        getAns(a, b, c, d, e, f);
    }
}
