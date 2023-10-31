package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1248 {

    static int n;
    static String arr;
    static int[] result;
    static char[][] signArr;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static void dfs(int depth) {

        if (depth == n) {
            for (int l : result) {
                System.out.print(l + " ");
            }
            System.out.println();
            System.exit(0);

        }

        for(int i = - 10; i <= 10; i++){
            result[depth] = i;
            if (check(depth + 1)) {
                dfs(depth + 1);
            }
        }

    }

    private static boolean check(int length) {
        for(int i = 0; i < length; i++){
            int sum = 0;
            for(int j = i; j < length; j++){
                sum += result[j];
                if (signArr[i][j] != (sum == 0 ? '0' : (sum > 0) ? '+' : '-')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        signArr = new char[n][n];
        result = new int[n];

        String sign = br.readLine();

        int idx = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                signArr[i][j] = sign.charAt(idx++);
            }
        }

        dfs(0);

    }

}
