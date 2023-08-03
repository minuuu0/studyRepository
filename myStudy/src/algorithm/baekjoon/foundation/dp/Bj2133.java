package algorithm.baekjoon.foundation.dp;

import java.util.*;
import java.io.*;
public class Bj2133 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[31];

        dp[0] = 1;
        dp[2] = 3;
        // 4부터 짝수번째 타일링 구하기
        for(int i = 4; i <= n; i+=2){
            dp[i] = dp[i - 2] * 3; // 일정 패턴의 경우
            for(int j = 4; j <= i; j+=2){
                dp[i] += dp[i - j] * 2; // 특이 패턴의 경우
            }
        }

        System.out.println(dp[n]);
    }

}
