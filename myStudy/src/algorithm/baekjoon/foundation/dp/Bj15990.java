package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj15990 {

    static final int MOD = 1000000009;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[][] dp = new long[100001][4];
    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        dp[1][1] = 1; // 1
        dp[2][2] = 1; // 2
        dp[3][1] = 1; // 2 + 1
        dp[3][2] = 1; // 1 + 2
        dp[3][3] = 1; // 3

        for(int i = 4; i < 100001; i++){
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD; // 1로 끝나는 수식 := i - 1의 수식에서 2와 3으로 끝나는 수식(같은 수 방지)
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD; // 2로 끝나는 수식 := i - 2의 수식에서 1과 3으로 끝나는 수식(같은 수 덧셈 방지)
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD; // 3로 끝나는 수식 := i - 3의 수식에서 1과 2로 끝나는 수식(같은 수 방지)
        }

        while (t > 0){
            int n = Integer.parseInt(br.readLine());

            System.out.println((dp[n][1] + dp[n][2] + dp[n][3]) % MOD);
            t--;
        }
    }
}
