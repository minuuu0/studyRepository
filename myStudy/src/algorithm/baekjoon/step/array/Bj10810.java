package algorithm.baekjoon.step.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10810 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 바구니 N
        int m = Integer.parseInt(st.nextToken()); // 공을 넣는 방법 M

        // m번 공을 넣어 공이 있는 경우 공을빼고 새로 집어 넣는다
        // 공을 넣는 방식은 세정수(i, j, k)로 이루어져 있고 i ~ j까지 k번 번호가 적혀있는 공을 넣는다.
        int[] arr = new int[n + 1];
        for(int c = 0; c < m; c++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            for(int l = i; l <= j; l++){
                arr[l] = k;
            }
        }

        for(int i = 1; i <= n; i++){
            System.out.print(arr[i] + " ");
        }

    }
}
