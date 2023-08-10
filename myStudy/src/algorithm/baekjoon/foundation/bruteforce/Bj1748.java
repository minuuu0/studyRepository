package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1748 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int plus = 1;
        int num = 10; // 몇자리수 더할지

        int count = 0;

        // 정답은 long

        for(int i = 1; i <= n; i++){
            if(i % num == 0){ // 자리수가 바뀔 때 10, 100, 1000 num값을 계속 증가시켜서 자리수가 바뀔때만 반복하게 함
                plus++;
                num *= 10;
            }
            count += plus;
        }
        System.out.println(count);
    }

}
