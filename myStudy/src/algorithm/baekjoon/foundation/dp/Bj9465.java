package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj9465 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[3][n + 1];
            int[][] dp = new int[3][n + 1];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 1; i < n + 1; i++){
                arr[1][i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 1; i < n + 1; i++){
                arr[2][i] = Integer.parseInt(st.nextToken()); // 2 x n 스티커 입력
            }

            dp[1][1] = arr[1][1];
            dp[2][1] = arr[2][1]; // 초기값 세팅

            int max = 0;

            for(int i = 2; i < n + 1; i++){
                dp[1][i] = Math.max(dp[2][i - 2], dp[2][i - 1]) + arr[1][i];
                dp[2][i] = Math.max(dp[1][i - 2], dp[1][i - 1]) + arr[2][i];
            }

            System.out.println(Math.max(dp[1][n], dp[2][n]));
        }
    }

}
