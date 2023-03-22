package algorithm.syu.reculsive;

import java.util.Scanner;

public class RemainPow {
    static final Scanner sc = new Scanner(System.in);
    private static int getRemainPow(int n, int x, int m) { // 2 5 3
        if(x == 1) return n % m; // 2의 1승을 구할 수 있다 = 2의 k승과 2의 k+1승을 구할 수 있다
        // ex ) 2 ^ 2 = 4  -> 2 ^ 4 = 4 * 4 || 2 ^ 3 = 2 * 2 * n
        int val = getRemainPow(n, x / 2, m); // 제곱을 반으로 쪼개 재귀함수 호출
        val = val * val % m; // value값의 제곱에 m을 나머지연산한다
        if(x % 2 == 0) return val;
        return val * n % m; // 홀수라면
    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 제곱할 데이터
        int x = sc.nextInt(); // 몇제곱 할건가
        int m = sc.nextInt(); // 나머지 연산

        int answer = getRemainPow(n, x, m);
        System.out.println(answer);
    }
}
