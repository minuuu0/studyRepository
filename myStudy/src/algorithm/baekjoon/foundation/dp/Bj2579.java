package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2579 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine()); // t = 계단의 개수 300이하 O(t ^ 3)까지 가능
        int[] arr = new int[t + 1]; // 계단별 점수는 10000 이하 자연수
        int[] dp = new int[t + 1]; // 최대값 갱신 배열

        for(int i = 1; i <= t; i++){
            arr[i] = Integer.parseInt(br.readLine()); // 계단
        }
        dp[1] = arr[1]; // 10
        dp[2] = arr[1] + arr[2]; // 20
        dp[3] = Math.max(arr[1], arr[2]) + arr[3]; // 더 큰 수에 3번째계단을 더해줌

        for(int i = 4; i <= t; i++){ // 계단 순회
            dp[i] = Math.max(dp[i - 3] + arr[i - 1], dp[i - 2]) + arr[i];
        }

        System.out.println(dp[t]);
    }

}
