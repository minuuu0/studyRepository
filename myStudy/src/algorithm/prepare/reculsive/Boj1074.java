package algorithm.prepare.reculsive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1074 {

    static int N, R, C;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        N = Integer.parseInt(s.nextToken()); // 2^n만큼의 크기
        R = Integer.parseInt(s.nextToken());
        C = Integer.parseInt(s.nextToken());
        int ans = func(N, R, C);
        System.out.println(ans);
    }

    static int func(int n, int r, int c) {
        if (n == 0) return 0;
        int half = 1 << (n - 1);
        if (r < half && c < half) return func(n - 1, r, c - half);
        if (r < half && c >= half) return half * half + func(n - 1, r, c - half);
        if (r >= half && c < half) return 2 * (half * half) + func(n - 1, r - half, c);
        return 3 * (half * half) + func(n - 1, r - half, c - half);
    }
}
