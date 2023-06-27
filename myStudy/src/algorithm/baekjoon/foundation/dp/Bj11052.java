package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11052 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 카드의 개수 N
        int[] cards = new int[n + 1]; // 각 카드의 가격
        int[] dp = new int[n + 1]; // i개의 카드를 살 때 최대값

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n + 1; i++){
            cards[i] = Integer.parseInt(st.nextToken()); // 묶음 카드 가격
        }

        dp[1] = 1; // 초기값 설정

        for(int i = 1; i < n + 1; i++){ // 1based

            // 각 경우의 수에 맞게 점화식 구성
            for(int j = 1; j < i + 1; j++){ // dp[i] = i개의 카드를 살 때 최대값
                dp[i] = Math.max(cards[j] + dp[i - j], dp[i]); // dp[2] = p[1] + dp[1] or dp[0] + p[2] 중 최대값 -> 이중 반복을 통해 최대값 갱신
            }
        }
        System.out.println(dp[n]);

    }
}
