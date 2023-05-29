package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10872 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int getFactorial(int n) {
        if(n<=1) return 1;
        return n * getFactorial(n - 1);
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int result = getFactorial(n);
        System.out.println(result);
    }
}
