package algorithm.baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2231 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int divSum(int n) {
        for(int i = 1; i <= n; i++){
            int num = i;
            int sum = 0;

            // 1 ~ 216까지 완전 탐색
            while (num != 0){
                sum += num % 10;
                num /= 10;
            }
            if(sum + i == n){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int ans = divSum(n);
        System.out.println(ans);

    }
}
