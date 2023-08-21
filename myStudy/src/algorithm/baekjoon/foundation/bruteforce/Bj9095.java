package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj9095 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            // testCase
            int num = Integer.parseInt(br.readLine());

            int answer = countWays(num);
            System.out.println(answer);
        }

    }

    private static int countWays(int num) {  // 재귀를 이용
        if(num == 0){
            return 1; // 더이상 나눌 수 없을 때
        } else if (num < 0) {
            return 0; // 음수가 되면 불가능
        }
        int ways = 0;

        for(int i = 1; i <= 3; i++){
            ways += countWays(num - i); // cw(n) = cw(n-1) + cw(n-2) + cw(n-3);
        }

        return ways;
    }
}
