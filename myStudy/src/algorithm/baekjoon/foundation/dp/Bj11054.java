package algorithm.baekjoon.foundation.dp;

import java.io.*;
import java.util.*;
public class Bj11054{

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        int[] inc_dp = new int[n+1];
        int[] dec_dp = new int[n+1];
        int max = Integer.MIN_VALUE;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i < n + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for(int i = 1; i < n + 1; i++){
            inc_dp[i] = 1;
            for(int j = 1; j < i + 1; j++){
                if(arr[i] > arr[j]){
                    inc_dp[i] = Math.max(inc_dp[i], inc_dp[j] + 1);
                }
            }
        }

        for(int i = n; i > 0; i--){
            dec_dp[i] = 1;
            for(int j = n; j > i; j--) {
                if(arr[i] > arr[j]){
                    dec_dp[i] = Math.max(dec_dp[i], dec_dp[j] + 1);
                }
            }
        }

        for(int i = 1; i < n + 1; i++){
            max = Math.max(inc_dp[i] + dec_dp[i], max);
        }

        System.out.println(max - 1);

    }

}