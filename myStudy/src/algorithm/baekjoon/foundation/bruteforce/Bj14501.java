package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14501 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[] t;
    static int[] p;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        // t는 최대 5일
        t = new int[n + 5];
        p = new int[n + 5];
        dp = new int[n + 5]; // i까지 벌 수 있는 최대 금액

        for(int i = 1; i <= n; i++){ // 1based
            st = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(st.nextToken());
            p[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = n; i > 0; i--){
            if(i + t[i] > n + 1){ // 퇴사일이 넘어간다면
                dp[i] = dp[i + 1]; // 상담하지 않고 끝
            }else{
                // 상담 가능
                dp[i] = Math.max(p[i] + dp[i + t[i]], dp[i + 1]);
                // 오늘 상담을 하는 경우와 하지 않는 경우 중 큰 값을 선택
            }
        }

        System.out.println(dp[1]);
    }
}
