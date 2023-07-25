package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1149 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 집의 수
        int[][] costs = new int[n + 1][3];
        int[][] dp = new int[n + 1][3];

        for(int i = 1; i < n + 1; i++){ // 비용 채우기
            StringTokenizer st = new StringTokenizer(br.readLine());

            costs[i][0] = Integer.parseInt(st.nextToken()); // R
            costs[i][1] = Integer.parseInt(st.nextToken()); // G
            costs[i][2] = Integer.parseInt(st.nextToken()); // B
        }

        dp[1][0] = costs[1][0];
        dp[1][1] = costs[1][1]; // 초기값
        dp[1][2] = costs[1][2];

        for(int i = 1; i < n + 1; i++){ // dp := 비용의 최소값
                // red
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + costs[i][0];

            // Green
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + costs[i][1];

            // Blue
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + costs[i][2];
        }

        int minCost = Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
        System.out.println(minCost);
    }
}
