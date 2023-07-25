package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1309 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static final int mod = 9901;
    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine()); // 2 * n의 우리의 크기
        int[][] dp = new int[n + 1][3];

        dp[1][0] = 1; // 미배치
        dp[1][1] = 1; // 왼쪽 배치
        dp[1][2] = 1; // 오른쪽 배치

        for(int i = 2; i < n + 1; i++){
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2])% mod; // 미배치의 경우
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][1]) % mod; // 왼쪽 배치의 경우
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
        }
        System.out.println((dp[n][0] + dp[n][1] + dp[n][2]) % mod);

    }
}
