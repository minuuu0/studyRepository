package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj15656 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static int[] area;
    static int[] arr; // n의 값
    static int n, m;

    private static void solve(int k) {
        if(k == m){
            for (int i : area) {
                sb.append(i + " ");
            }
            sb.append('\n');
            return;
        }

        for(int i = 1; i <= n; i++){
            area[k] = arr[i];
            solve(k + 1);
        }


    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        area = new int[m];
        arr = new int[n + 1];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solve(0);

        System.out.println(sb);

    }
}
