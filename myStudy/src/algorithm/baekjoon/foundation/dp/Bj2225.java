package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2225 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int mod = 1000000000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 0 ~ n까지
        int k = Integer.parseInt(st.nextToken()); // 정수 k를 더해 그 합이 n인 수

        long[][] dp = new long[k + 1][n + 1];

        for(int i = 0; i < n + 1; i++){
            dp[1][i] = 1;
        }

        for(int i = 0; i < k + 1; i++){
            dp[i][0] = 1;
        }

        for (int i = 2; i < k + 1; i++){
            for(int j = 1; j < n + 1; j++){
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % mod;
            }
        }

        System.out.println(dp[k][n]);

    }

}
