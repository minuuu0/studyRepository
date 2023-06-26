package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj11726{

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp = new int[1001]; // dp[i] := 2x1 or 1X2로 덮을 경우의 수

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine()); // 2 x n 의 타일 수를 구한다.
        dp[1] = 1;
        dp[2] = 2; // 초기값 부여

        for(int i = 3; i < n + 1; i++){
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007; // 크기 조절을 위한 나머지 연산
        }

        System.out.println(dp[n]);
    }
}
