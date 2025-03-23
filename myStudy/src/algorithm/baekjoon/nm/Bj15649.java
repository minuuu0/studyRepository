package algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15649 {

    static boolean[] visited;
    static int n;
    static int m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];

        // 1 ~ n까지, 자연수 중에서 중복없이 m개를 고른 수열
        for (int i = 0; i < n; i++) {
            dfs(i);
        }

    }

    private static void dfs(int num) {

        for
    }

}
