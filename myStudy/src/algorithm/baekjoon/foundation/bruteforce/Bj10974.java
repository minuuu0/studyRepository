package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10974 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static int n;
    static int[] area;
    static boolean[] checked;
    private static void solve(int k) {
        if(k == n){
            for (int i : area) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= n; i++){
            if(!checked[i - 1]){
                area[k] = i;
                checked[i - 1] = true;
                solve(k + 1);
                checked[i - 1] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        area = new int[n];
        checked = new boolean[n];

        solve(0);

        System.out.println(sb);

    }
}
