package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1373 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        String n = br.readLine(); // 100만 미만의 이진 수
        int sum = 0;

        // 2진수의 길이가 3의 배수가 아닌 경우 0추가
        while (n.length() % 3 != 0){
            n = "0" + n;
        }

        for (int i = 0; i < n.length(); i += 3) {
            int decimal = Integer.parseInt(n.substring(i, i + 3), 2); // 3개씩 끊고, 2진수 값 적용
            sb.append(decimal);
        }
        System.out.println(sb);

    }
}
