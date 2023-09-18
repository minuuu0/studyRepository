package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj15664 {
    static int n, m;
    static boolean[] checked;
    static int[] area;
    static int[] arr;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void solve(int k, int l) {
        if(k == m){
            for (int i : area) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1;
        for(int i = l; i < n; i++){
            if (!checked[i] && prev != arr[i]) {
                checked[i] = true;
                area[k] = arr[i];
                prev = arr[i];
                solve(k + 1, i);
                checked[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        checked = new boolean[n];
        area = new int[m];
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        int i = 0;
        while (st.hasMoreTokens()){
            arr[i++] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        solve(0, 0);

        System.out.println(sb);

    }
}
