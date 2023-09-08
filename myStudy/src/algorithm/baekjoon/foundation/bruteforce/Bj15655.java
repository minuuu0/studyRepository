package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj15655 {

    static int n, m;
    static boolean[] checked;
    static int[] area;
    static int[] arr;
    static StringTokenizer st;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void solve(int k, int l) {
        if(k == m){
            for (int i : area) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = l; i <= n; i++){
            if (!checked[i]) {
                area[k] = arr[i];
                checked[i] = true;
                solve(k + 1, i);
                checked[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        checked = new boolean[n + 1];
        area = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        solve(0, 1); // n은 1부터 시작
    }

}
