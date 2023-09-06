package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15651 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static int n, m;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m]; // m개의 원소가 꽉찼는지 확인

        solve(0, 1);
        System.out.println(sb);

    }

    private static void solve(int k, int l) {
        if(k == m){
            for(int i : arr){
                sb.append(i + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i = l; i <= n; i++){
            arr[k] = i;
            solve(k + 1, i);
        }
    }
}
