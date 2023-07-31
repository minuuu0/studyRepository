package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11722 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 수열의 수
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(arr[i] < arr[j]){ //
                    dp[i] = Math.max(dp[i], dp[j] + 1); // 최장 길이를 구해야하니 max
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);

    }
}
