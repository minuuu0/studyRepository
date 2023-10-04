package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10971 {

    static int[][] w;
    static int n;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    private static void solve(int start, int current, int depth, int cost) {
        if(depth == n - 1){
            if(w[current][start] != 0){
                min = Math.min(min, cost + w[current][start]);
            }
            return;
        }

        visited[current] = true;
        for(int next = 0; next < n; next++){
            if(!visited[next] && w[current][next] != 0){
                solve(start, next, depth + 1, cost + w[current][next]);
            }
        }
        visited[current] = false;
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n];

        w = new int[n][n];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0; i < n; i++){
            solve(i, i, 0, 0);
        }
        System.out.println(min);

    }

}
