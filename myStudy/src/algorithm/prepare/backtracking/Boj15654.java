package algorithm.prepare.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj15654 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] area;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        N = Integer.parseInt(s.nextToken());
        M = Integer.parseInt(s.nextToken());
        area = new int[M];
        arr = new int[N];
        visited = new boolean[10001];

        s = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s.nextToken());
        }
        Arrays.sort(arr);

        dfs(0);
        System.out.println(sb);
    }

    static void dfs(int depth) {
        if (depth == M) {
            for (int n : area) {
                sb.append(n + " ");
            }
            sb.append("\n");
            return;
        }
        for (int n : arr) {
            if (!visited[n]) {
                visited[n] = true;
                area[depth] = n;
                dfs(depth + 1);
                visited[n] = false;
            }

        }
    }

}
