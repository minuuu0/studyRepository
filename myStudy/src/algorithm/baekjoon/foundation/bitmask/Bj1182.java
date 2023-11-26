package algorithm.baekjoon.foundation.bitmask;

import java.io.*;
import java.util.*;

public class Bj1182 {

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


        for(int i = 1; i < (1 << n); i++){ // 1 ~ 8
            sum = 0;
            for(int j = 0; j < n; j++){   // 0 ~ 2
                if ((i & (1 << j)) != 0) {
                    sum += arr[j];
                    System.out.print(arr[j] + ", ");
                }
            }
            System.out.println();

            if(sum == s) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }




}
