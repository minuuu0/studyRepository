package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1676 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException { // 3628800 // 362880 / 40320 / 5040 / 720 / 120 / 24
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        // 1 ~ n까지의 5의 개수만 알면 된다.
        // 5는 5를 1개 가지고 있으나 25는 5를 2개 가지고 있고 125는 3개 가지고 있다. 즉 제곱에 따라 5의 개수가 증가한다.

        // x % 5==0이라면 5가 1개 있는 것
        // 짝수는 무조건 2가 있으나 5는

        while (n >= 5){ // 제곱 수만큼 반복
            cnt += n / 5; // 1~n까지의 5의 개수가 나온다.
            n/= 5; // 5를 나눠준다
        }
        System.out.println(cnt);

    }
}
