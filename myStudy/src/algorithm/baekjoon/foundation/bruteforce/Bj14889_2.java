package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj14889_2 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n;
    static int[][] arr;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        arr = new int[n][n];
        visited = new boolean[n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);

    }

    private static void dfs(int depth, int start) {
        if (depth == n / 2) {
            sum();
            return;
        }
        for(int i = start; i < n; i++){
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    private static void sum() {
        int start_team = 0;
        int link_team = 0;

        for(int i = 0; i < n - 1; i++){
            for(int j = i + 1; j < n; j++){
                if(visited[i] == true && visited[j] == true){ // 같은 팀의 경우
                    start_team += arr[i][j] + arr[j][i];
                }
                else if(visited[i] == false && visited[j] == false){
                    link_team += arr[i][j] + arr[j][i];
                }
            }
        }

        min = Math.min(min, Math.abs(start_team - link_team));
    }
}
