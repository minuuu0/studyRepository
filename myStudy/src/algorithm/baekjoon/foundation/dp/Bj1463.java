package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1463 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine()); // 정수 n (1000000) -> 시간복잡도 O(n)안에 수행

        int[] dp = new int[1000001]; // 배열에는 최소 거리가 들어간다.
        dp[1] = 0;


        for(int i = 2; i < 1000001; i++){ // 해당 범위를 순회하며
            dp[i] = dp[i - 1] + 1;
            if(i % 3 == 0){ // 10의 경우
                dp[i] = Math.min(dp[i], dp[i / 3] + 1); // dp[12] = dp[4] + 1;
            }
            if (i % 2 == 0) { //
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }
        }
        System.out.println(dp[N]);


    }
}
