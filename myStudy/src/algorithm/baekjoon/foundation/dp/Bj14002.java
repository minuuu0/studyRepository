package algorithm.baekjoon.foundation.dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj14002 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 수열의 크기

        int[] arr = new int[n + 1]; // 수열 데이터
        int[] dp = new int[n + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i < n + 1; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            dp[i] = 1;
        }

        int max = 0;

        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < i; j++){
                if(arr[i] > arr[j]){ // 작은 원소를 만나면
                    dp[i] = Math.max(dp[i], dp[j] + 1 );
                }
            }
            max = Math.max(max, dp[i]);
        }

        // 역추적하기
        int value = max; // 최대 길이 수
        Stack<Integer> stack = new Stack<>();

        for(int i = n; i >= 1; i--){
            if(value == dp[i]){
                stack.push(arr[i]);
                value--;
            }
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }

        System.out.println(max);
        System.out.println(sb);
    }

}
