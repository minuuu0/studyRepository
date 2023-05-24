package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10824 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        long num1 = Long.parseLong(st.nextToken() + st.nextToken()); // 1000000과 100000을 붙이면 int의 범위를 넘어간다.
        long num2 = Long.parseLong(st.nextToken() + st.nextToken());

        System.out.println(num1 + num2);

    }
}
