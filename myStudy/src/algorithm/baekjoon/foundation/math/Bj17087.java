package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj17087 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int getGCD(int a, int b) {
        if(b == 0) return a;
        return getGCD(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 동생의 수
        int S = Integer.parseInt(st.nextToken()); // 수빈의 위치
        int[] arr = new int[N]; // 동생과의 거리를 나타낼 배열

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Math.abs(Integer.parseInt(st.nextToken()) - S);
        }

        int result = arr[0];
        for(int i = 1; i < N; i++){

            result = getGCD(result, arr[i]);
        }
        System.out.println(result);
    }
}
