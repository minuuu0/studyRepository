package algorithm.baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj2231 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int ans = 0;

        while(n > 10){
            int a = n % 10; // 자리수별로 쪼개고
            n - a;
        }

        System.out.println(ans);
    }
}
