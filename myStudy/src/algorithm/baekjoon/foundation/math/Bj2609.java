package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2609 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int getGcd(int a, int b) { // 유클리드 호제법 gcd(a, b) = gcd(b, r) r == a % b
        if(b == 0){
            return a;
        }
        return getGcd(b, a % b);
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int gcd = getGcd(a, b);

        System.out.println(gcd);
        System.out.println(a * b / gcd);

    }
}
