package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1932 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for(int i = 1; i < n + 1; i++){ // 삼각형 값 할당
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j < i + 1; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[1][1] = arr[1][1]; // 초기값 설정
        if(n > 1){
            dp[2][1] = arr[1][1] + arr[2][1];
            dp[2][2] = arr[1][1] + arr[2][2];
        }

        for(int i = 3; i < n + 1; i++){
            for(int j = 1; j < i + 1; j++){
                dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
            }
        }

        int max = 0;
        for(int i = 1; i < n + 1; i++){
            max = Math.max(max, dp[n][i]);
        }
        System.out.println(max);
    }

}
