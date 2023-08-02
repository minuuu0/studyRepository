package algorithm.baekjoon.foundation.dp;

import java.util.*;
import java.io.*;

public class Bj13398 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[][] dp = new int[n][2];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int max = arr[0];
        dp[0][0] = dp[0][1] = arr[0];

        for(int i = 1; i < n; i++){
            dp[i][0] = dp[i][1] = arr[i];
            dp[i][0] = Math.max(arr[i], dp[i - 1][0] + arr[i]); // i까지 연속된 수 중 최대값 (1개 제거x)
            dp[i][1] = Math.max(dp[i - 1][0], dp[i - 1][1] + arr[i]); // i까지 연속된 수 중 수열에서 1개를 제외했을 때 최대값 (1개제거 o)
            max = Math.max(max, Math.max(dp[i][0], dp[i][1])); // 답
        }


        System.out.println(max);

    }
}
