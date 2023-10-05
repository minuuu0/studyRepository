package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10971_1 {

    static int n;
    static int min = Integer.MAX_VALUE;
    static boolean[] visited;
    static int[][] w;
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

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

    private static void solve(int start, int current, int depth, int cost) {
        if(depth == n - 1){
            if(w[current][start] != 0){ // 길이 없으면 갱신하면 안된다.
                min = Math.min(min, cost + w[current][start]);
            }
            return;
        }
        visited[current] = true;
        for(int i = 0; i < n; i++){
            if (!visited[i] && w[current][i] != 0) { // 길이 없으면 가지 않게 한다
                solve(start, i, depth + 1, cost + w[current][i]);
            }
        }
        visited[current] = false;
    }
}
