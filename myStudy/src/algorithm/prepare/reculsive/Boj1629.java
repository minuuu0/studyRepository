package algorithm.prepare.reculsive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1629 {

    // B의 범위가 21억이니 그냥 재귀로 구하면 시간초과 메모리초과가 발생한다.
    // 지수법칙 A^(n+m) = A^N * A^M
    // 모듈러 성질 (A * B) mod C = (A mod C * B mod C) mod C
    // (A * B) % C = (A % C * B % C) % C

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());

        long A = Integer.parseInt(s.nextToken());
        long B = Integer.parseInt(s.nextToken());
        long C = Integer.parseInt(s.nextToken());
        System.out.print(POW(A, B, C));
    }

    static long POW(long a, long b, long m ) {
        if (b == 1) return a % m;
        long val = POW(a, b / 2, m);
        val = val * val % m;
        if (b % 2 == 0) return val;
        return val * a % m;
    }

}
