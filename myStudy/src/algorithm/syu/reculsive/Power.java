package algorithm.syu.reculsive;

import java.util.Scanner;

public class Power {

    static final Scanner sc = new Scanner(System.in);
    private static int getPower(int n, int x) {
        if(x == 0) return 1; // 제곱이 0이되면 return 1
        else if (x % 2 == 0){ // 제곱이 짝수라면
            return getPower(n * n, x / 2);
        }else{ // 제곱이 홀수라면
            return n * getPower(n * n, (x-1) / 2);
        }
        //return n * getPower(n, x - 1); < 이 방식도 가능


        // 사실 반복문 이용하면
        // for(int i = 0; i < x; i++){ r *= n; (r = 1)}
    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 제곱할 데이터
        int x = sc.nextInt(); // 몇제곱 할 것인지
        int answer = getPower(n, x); // 제곱한 값을 구하는 함수 생성

        System.out.println(answer); // 값 출력
    }
}
