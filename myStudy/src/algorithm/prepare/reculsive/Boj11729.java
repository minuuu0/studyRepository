package algorithm.prepare.reculsive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11729 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = (int) Math.pow(2, N) - 1;
        System.out.println(cnt);
        func(1, 3, N);
        System.out.println(sb);
    }

    // 원판 n개를 a번기둥에서 b번기둥으로 옮기는 함수
    // n - 1개의 원판이 1번기둥에 있을지 2번기둥에 있을지
    static void func(int a, int b, int N) {
        if (N == 1) {
            sb.append(a + " " + b + "\n");
            return;
        }

        func(a, 6 - a - b, N - 1);
        sb.append(a + " " + b + "\n");
        func(6 - a - b, b, N - 1);
    }

}
