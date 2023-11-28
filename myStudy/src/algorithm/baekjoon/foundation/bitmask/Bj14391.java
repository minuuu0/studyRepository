package algorithm.baekjoon.foundation.bitmask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14391 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m];

        for(int i = 0; i < n; i++){
            String s = br.readLine();
            for(int j = 0; j < m; j++){
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        int ans = 0;

        for (int s = 0; s < (1 << (n * m)); s++) {
            int sum = 0;
            // 가로 0 찾기
            for (int i = 0; i < n; i++) {
                int cur = 0; // 현재 종이의 숫자
                for (int j = 0; j < m; j++) { // m:= 세로길이
                    int idx = i * m + j;
                    if ((s & (1 << idx)) == 0) { // s의 k번째 비트가 0이면 -> 해당 숫자는 가로
                        cur *= 10;
                        cur += arr[i][j];
                    }else{
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }

            // 세로 1 찾기
            for (int j = 0; j < m; j++) {
                int cur = 0;

                for (int i = 0; i < n; i++) {
                    int idx = i * m + j;
                    if ((s & (1 << idx)) != 0) {
                        cur *= 10;
                        cur += arr[i][j];
                    } else {
                        sum += cur;
                        cur = 0;
                    }
                }
                sum += cur;
            }
            ans = Math.max(ans, sum);
        }
        System.out.println(ans);
    }

}
