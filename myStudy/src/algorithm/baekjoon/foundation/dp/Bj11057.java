package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj11057 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int mod = 10007;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[n + 1][10];
        int result = 0;

        for(int i = 0; i < 10; i++){
            dp[1][i] = 1; // 초기값
        }

        for(int i = 2; i < n + 1; i++){
            for (int j = 0; j < 10; j++){ // dp[i][j] 각 자리수에 대해
                for(int k = j; k < 10; k++){
                    dp[i][j] = (dp[i - 1][k] + dp[i][j]) % mod;
                }
            }
        }

        for(int i = 0; i < 10; i++){
            result = (result + dp[n][i]) % mod;
        }
        System.out.println(result % mod);

    }

}
