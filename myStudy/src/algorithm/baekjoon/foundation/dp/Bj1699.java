package algorithm.baekjoon.foundation.dp;

import java.io.*;
public class Bj1699 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 최악의 경우로 초기화
            for (int j = 1; j * j <= i; j++) { // 제곱일 때마다 바뀐다
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        System.out.println(dp[n]);
    }

}
