package algorithm.prepare.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15652 {

    static int N, M;
    static int[] area;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        N = Integer.parseInt(s.nextToken());
        M = Integer.parseInt(s.nextToken());
        area = new int[M];

        dfs(0, 0);
        System.out.println(sb);
    }

    static void dfs(int depth, int prev) {
        if (depth == M) {
            for (int n : area) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < N; i++) {
            if (i + 1 >= prev) {
                area[depth] = i + 1;
                dfs(depth + 1, i + 1);
            }
        }
    }

}
