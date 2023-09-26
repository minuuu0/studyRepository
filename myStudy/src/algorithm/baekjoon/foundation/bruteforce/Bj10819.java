package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10819 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    static int n;
    static int[] arr;
    static int[] ans;
    static boolean[] visit;
    static int result;

    private static void dfs(int k) {
        if(k == n){
            int sum = 0;
            for(int i = 0; i < n-1; i++){
                sum += Math.abs(ans[i] - ans[i + 1]);
            }
            result = Math.max(result, sum);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!visit[i]){
                ans[k] = arr[i];
                visit[i] = true;
                dfs(k + 1);
                visit[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        ans = new int[n];
        visit = new boolean[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(result);
    }

}
