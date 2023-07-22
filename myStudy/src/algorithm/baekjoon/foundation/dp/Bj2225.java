package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2225 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final int mod = 1000000000;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 0 ~ n까지
        int k = Integer.parseInt(st.nextToken()); // 정수 k를 더해 그 합이 n인 수

        long[][] dp = new long[n + 1][k + 1];

        for(int i = 0; i < n + 1; i++){
            dp[i][1] = 1;
        }
        for(int i = 0; i < k + 1; i++){
            dp[0][i] = 1;
        }
        System.out.println("hi");


    }

}
