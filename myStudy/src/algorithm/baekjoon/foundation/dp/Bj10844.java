package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10844 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long mod = 1000000000;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        long[][] dp = new long[n + 1][10];

        for(int i = 1; i < 10; i++){
            dp[1][i] = 1; // 초기값 세팅
        }

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < 10; j++){
                if(j == 9) dp[i][j] = dp[i - 1][8] % mod; // 9는 8만 나올 수 있음
                else if(j == 0) dp[i][j] = dp[i - 1][1] % mod; // 0은 1만 나올 수 있음
                else{
                    dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
                }
            }
        }

        long ans = 0;
        for(int i = 0; i < 10; i++){
            ans += dp[n][i];
        }
        System.out.println(ans % mod);

    }
}
