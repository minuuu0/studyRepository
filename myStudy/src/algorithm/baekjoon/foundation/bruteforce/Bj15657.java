package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj15657 {

    static int n, m;
    static int[] area;
    static int[] arr; // n을 입력받을 배열
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void solve(int k, int l) {

        if(k == m){
            for (int i : area) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }
        for(int i = l; i < n; i++){
            area[k] = arr[i];
            solve(k + 1, i);
        }

    }

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        area = new int[m];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        solve(0, 0);

    }

}
