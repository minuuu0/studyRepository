package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2156 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for(int i = 1; i < n + 1; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];
        if(n > 1){
            dp[2] = arr[1] + arr[2];
        }
        for(int i = 3; i < n + 1; i++){
            dp[i] = Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]); // i번째 잔을 먹지 않는 경우
            dp[i] = Math.max(dp[i], dp[i - 1]); // i 번째 잔을 먹을 경우
        }

        System.out.println(dp[n]);
    }

}
