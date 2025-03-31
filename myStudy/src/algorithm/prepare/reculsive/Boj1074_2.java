package algorithm.prepare.reculsive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1074_2 {
    static int temp = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(s.nextToken());
        int R = Integer.parseInt(s.nextToken());
        int C = Integer.parseInt(s.nextToken());
        Z(N, R, C);
        System.out.println(temp);
    }

    static void Z(int n, int r, int c) {
        if (n == 0) {
            return;
        }

        int mid = (int) Math.pow(2, n) / 2;
        if (r >= mid && c < mid) {
            temp += (mid * mid * 2);
            Z(n - 1, r - mid, c);
        } else if (c >= mid && r < mid) {
            temp += (mid * mid);
            Z(n - 1, r, c - mid);
        } else if (c < mid && r < mid) {
            Z(n - 1, r, c);
        } else {
            temp += (mid * mid * 3);
            Z(n - 1, r - mid, c - mid);
        }

    }
}
