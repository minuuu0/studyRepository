package algorithm.baekjoon.reculsion;

import java.util.Scanner;

public class Bj10872 {
    private static int Factorial(int n) {
        if(n > 1){
            return n * Factorial(n - 1);
        }else{
            return 1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n의 팩토리얼 구하기

        int result = Factorial(n);
        System.out.println(result);
    }
}
