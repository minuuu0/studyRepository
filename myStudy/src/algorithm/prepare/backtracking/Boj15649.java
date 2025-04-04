package algorithm.prepare.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj15649 {

    static int N, M;
    static int[] area;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        N = Integer.parseInt(s.nextToken());
        M = Integer.parseInt(s.nextToken());

        visited = new boolean[N];
        area = new int[M];
        getPerm(0);
        System.out.println(sb);

    }

    static void getPerm(int depth) {
        if (depth == M) {
            for (int n : area) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!visited[i - 1]) {
                area[depth] = i;
                visited[i - 1] = true;
                getPerm(depth + 1);
                visited[i - 1] = false;
            }
        }
    }
}
