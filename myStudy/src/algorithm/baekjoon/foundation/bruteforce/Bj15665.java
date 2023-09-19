package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj15665 {

    static int n, m;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
//    static boolean[] checked;
    static int[] area;
    static int[] arr;

    private static void solve(int k) {
        if(k == m){
            for (int i : area) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for(int i = 0; i < n; i++){
            if(prev != arr[i]){
                area[k] = arr[i];
                prev = arr[i];
                solve(k + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        area = new int[m];
//        checked = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solve(0);

        System.out.println(sb);

    }
}
