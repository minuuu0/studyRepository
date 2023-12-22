package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Bj2667 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int cnt;
    static int[][] adjMatrix;
    static int n;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        adjMatrix = new int[n][n];
        visited = new boolean[n][n];
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                adjMatrix[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (adjMatrix[i][j] == 1 && !visited[i][j]) { // 1을 만났다면 탐색을 통해 단지를 알아낸다.
                    cnt = 0;
                    dfs(i, j);
                    result.add(cnt);
                }
            }
        }

        Collections.sort(result);
        System.out.println(result.size());
        for (Integer integer : result) {
            System.out.println(integer);
        }

    }

    private static void dfs(int i, int j) {
        visited[i][j] = true;
        cnt++;

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];

            if (isValid(nx, ny) && adjMatrix[nx][ny] == 1 && !visited[nx][ny]) { // 방문하지 않은 것중 1인 값
                dfs(nx, ny);
            }
        }
    }

    private static boolean isValid(int nx, int ny) {
        return nx >= 0 && ny >= 0 && nx < n && ny < n;
    }

}
