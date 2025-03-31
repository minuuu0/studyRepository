package algorithm.prepare.reculsive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj11729_2 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        hanoi(n, 1, 3);
        System.out.println((int)Math.pow(2, n) - 1);
        System.out.println(sb);
    }

    static void hanoi(int n, int start, int goal) {
        if (n == 1) {
            sb.append(start + " " + goal).append("\n");
            return;
        }
        hanoi(n -  1, start, 6 - start - goal);
        sb.append(start + " " + goal).append("\n");
        hanoi(n - 1, 6 - start - goal, goal);
    }

}