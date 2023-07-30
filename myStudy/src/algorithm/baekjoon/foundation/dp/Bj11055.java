package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11055 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];
        int max = Integer.MIN_VALUE; // 최대값

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());}
        dp[1] = arr[1];

        for (int i = 1; i <= n; i++) {
            dp[i] = arr[i]; // 현재 위치 값으로 초기화
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
