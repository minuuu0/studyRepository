package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj15654 {

    static int n, m;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] arr; // n의 값이 들어감
    static boolean[] checked; // 중복 체크
    static int[] data; // 수열 값이 들어감

    private static void solve(int k) {
        if(k == m){
            for (int i : data) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 0; i < n; i++){
            if(!checked[i]){
                checked[i] = true;
                data[k] = arr[i];
                solve(k + 1);
                checked[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        checked = new boolean[n + 1]; // 1based
        data = new int[m];

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        solve(0);
    }

}
