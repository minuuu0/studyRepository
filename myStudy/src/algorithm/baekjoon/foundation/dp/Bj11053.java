package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11053 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int A = Integer.parseInt(br.readLine()); // 수열의 크기 A
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[A + 1]; // 1based
        int[] dp = new int[A + 1];


        for(int i = 1; i < A + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 수열이 들어간다
            dp[i] = 1; // 초기값
        }

        // dp[i] = i번째 수를 마지막 원소로 갖는 LIS의 길이
        int max = 1;

        for(int i = 1; i < A + 1; i++){
            for(int j = 1; j < i; j++){ // 순회하며 마지막 값이 i보다 작은 값을 찾는다
                if(arr[i] > arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1); // 다른 증가 수열이 나와도 최대값을 가지고 있어야 하기에 max연산
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

}
