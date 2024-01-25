package algorithm.baekjoon.foundation.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Bj2138_2 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static int n;
    static int[] origin;
    static int[] goal;

    public static void main(String[] args) throws IOException {

        n = Integer.parseInt(br.readLine());
        origin = new int[n];
        goal = new int[n];

        String str = br.readLine();

        for (int i = 0; i < n; i++) {
            origin[i] = str.charAt(i) - '0';
        }

        str = br.readLine();

        for (int i = 0; i < n; i++) {
            goal[i] = str.charAt(i) - '0';
        }


        int res1 = solve(true); // 첫 전구가 켜진 경우
        int res2 = solve(false); // 첫 전구가 꺼진 경우

        int result = Math.min(res1, res2);
        System.out.println(result >= 100000 ? -1 : result);

    }


    private static int solve(boolean first) {

        int[] bulb = Arrays.copyOf(origin, n);

        int cnt = 0;

        if (first) { // 첫 전구 처리
            flip(bulb, 0);
            cnt++;
        }

        for (int i = 1; i < n; i++) { // 이후 전구 처리
            if (bulb[i - 1] != goal[i - 1]) {
                flip(bulb, i);
                cnt++;
            }
        }

        if (Arrays.equals(bulb, goal)) {
            return cnt;
        } else
            return 100000;



    }

    // swap
    private static void flip(int[] arr, int index) {

        for (int i = index - 1; i <= index + 1; i++) {
            if (i >= 0 && i < n) {
                arr[i] = 1 - arr[i];
            }
        }
    }

}
