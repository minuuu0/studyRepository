package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Bj15663 {

    static int n, m;
    static boolean[] checked;
    static int[] area;
    static int[] arr;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void solve(int k) {
        if(k == m){
            for (int i : area) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        int prev = -1; // 중복 제거를 위함(정렬시엔 중복이 연속되어 있다)
        for(int i = 0; i < n; i++){
            if (!checked[i] && prev != arr[i]) {
                checked[i] = true;
                area[k] = arr[i];
                prev = arr[i];
                solve(k + 1);
                checked[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        area = new int[m];
        checked = new boolean[n];
        arr = new int[n];

        st = new StringTokenizer(br.readLine());


        int i = 0;
        while (st.hasMoreTokens()) {
            arr[i++] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solve(0);

        System.out.println(sb);
    }
}
