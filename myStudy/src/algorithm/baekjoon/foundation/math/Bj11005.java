package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11005 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // n은 10억 이하
        int b = Integer.parseInt(st.nextToken()); // b진법

        while (n > 0){
            int ch = n % b; // 나머지 연산
            if(ch < 10){
                // 정수라면
                sb.append(ch);
            }else{ // 문자라면
                int sum = ch + 55;
                sb.append((char)sum);
            }
            n /= b;
        }

        System.out.println(sb.reverse());
    }
}
