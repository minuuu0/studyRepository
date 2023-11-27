package algorithm.baekjoon.foundation.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1182_2 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, s, cnt;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];
        cnt = 0 ;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;

        for(int i = 1; i < (1 << n); i++){ // 공집합 제외
            sum = 0;
            for(int j = 0; j < n; j++){
                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                }
            }
            if (sum == s) {
                cnt++;
            }
        }

        System.out.println(cnt);

    }
}
