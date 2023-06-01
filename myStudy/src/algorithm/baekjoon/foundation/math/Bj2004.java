package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2004 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        // nCm = n! / (n-m)! * m!
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        // 뒤의 수들이 0이 되기 위해선 2와 5의 곱의 모음이다.
        // 1. 분자와 분모를 소인수분해하여 2, 5의 각 개수를 구한다.
        // 2. 분자의 2의 개수 - 분모의 2의 개수, 분자의 5의 개수 - 분모의 5의 개수
        // 남은 2의 개수와 5의 개수 중 작은 것을 출력한다.

        // 각각의 승 수를 구해준다.
        long count5 = five_power_n(n) - five_power_n(n - m) - five_power_n(m);  // 2번 수행
        long count2 = two_power_n(n) - two_power_n(n - m) - two_power_n(m);

        System.out.println(Math.min(count2, count5));

    }

    private static long two_power_n(long n) { // n!의 2의 개수 구하기
        int count = 0;

        while (n >= 2){
            count += n / 2;
            n /= 2;
        }
        return count;
    }

    private static long five_power_n(long n) {
        int count = 0;

        while (n >= 5){
            count += n / 5;
            n /= 5;
        }
        return count;
    }
}
