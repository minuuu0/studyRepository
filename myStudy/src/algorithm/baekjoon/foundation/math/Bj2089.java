package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2089 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        if(n == 0){
            sb.append(0);
        }else{
            while (n != 1){ // -2로 소인수 구하기
                sb.append(Math.abs(n %  -2));

                // 올림 처리를 위한 Math.ceil
                n = (int)(Math.ceil((double) n / - 2));
            }
            sb.append(n); // n 추가
        }
        System.out.println(sb.reverse()); // 결과 도출
    }

}
