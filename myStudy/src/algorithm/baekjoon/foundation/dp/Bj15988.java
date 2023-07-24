package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj15988 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long[] dp = new long[1000001];
    static int mod = 1000000009;

    public static void main(String[] args) throws IOException {
        // dp 채워두기
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 4 ; i < 1000001; i++){
            dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod;
        }

        int t = Integer.parseInt(br.readLine()); // 테스트케이스 수

        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }

    }

}
