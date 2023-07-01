package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj16194 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        int[] cards = new int[n + 1];
        int[] dp = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n + 1; i++){
            cards[i] = Integer.parseInt(st.nextToken());
            dp[i] = Integer.MAX_VALUE;
        }


        for(int i = 1; i < n + 1; i++){ // n := 4일 경우
            for(int j = 0; j < i ; j++){
                dp[i] = Math.min(dp[i], dp[j] + cards[i - j]);
            }
        }
        System.out.println(dp[n]);
    }
}
