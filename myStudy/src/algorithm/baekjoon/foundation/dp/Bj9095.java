package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj9095 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[11];

    private static void testCase() throws IOException{
        // 메인 로직
        int n = Integer.parseInt(br.readLine());
        for(int i = 4; i < n + 1; i++){
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        System.out.println(dp[n]);
    }

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i = 0; i < t; i++){
            testCase();
        }

    }
}
