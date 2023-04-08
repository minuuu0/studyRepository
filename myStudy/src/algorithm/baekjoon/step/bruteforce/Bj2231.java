package algorithm.baekjoon.step.bruteforce;

import java.util.Scanner;

public class Bj2231 {
    static final Scanner sc = new Scanner(System.in);
    private static int getConst(int n) {
        // 답 = n - 답의 각 자리수
        // 198 = 216 - (198 + 1 + 9 + 8)

        for(int i = 0; i <= n; i++){ // 0 ~ 216
            int j = i;
            int ans = i;
            while (j > 0){
                int rem = j % 10; // 일의자리 뽑기
                ans += rem; // 198 + 각 자리수
                j /= 10;
            }
            if(ans == n){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 자연수 n

        int answer = getConst(n);
        System.out.println(answer);

    }
}
