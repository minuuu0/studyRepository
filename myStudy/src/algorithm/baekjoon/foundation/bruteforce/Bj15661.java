package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj15661 {

    static int min = Integer.MAX_VALUE;
    static int n;
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] arr;
    static boolean[] visited;

    private static void dfs(int depth, int start) {
        if (depth == n) {
            return;
        }

        for(int i = start; i < n; i++){ // i := 1 ~ 4 -> 1based
            if (!visited[i - 1]) {
                visited[i - 1] = true;
                min();
                dfs(depth + 1, i + 1);
                visited[i - 1] = false;
            }
        }

    }

    private static void min() {
        int team_start = 0;
        int team_link = 0;

        for(int i = 0; i < n - 1; i++){ // i번째 선수
            for(int j = i + 1; j < n; j++){ // j번째 선수, j는 항상 i보다 크다(중복 방지)
                // true = start팀
                if (visited[i] == true && visited[j] == true) {
                    team_start += arr[i][j];
                    team_start += arr[j][i];
                }

                if (visited[i] == false && visited[j] == false) {
                    team_link += arr[j][i];
                    team_link += arr[i][j];
                }
            }
        }

        min = Math.min(min, Math.abs(team_link - team_start));
    }

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

        dfs(0, 1);
        System.out.println(min);
    }

}
