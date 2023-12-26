package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Bj2667_2 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] matrix;
    static boolean[][] visited;
    static int n;
    static ArrayList<Integer> result = new ArrayList();
    static int cnt;

    public static void main(String[] args) throws IOException{
        n = Integer.parseInt(br.readLine());
        matrix = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && matrix[i][j] == 1) {
                    cnt = 0; // 첫 방문시 초기화
                    dfs(i, j);
                    result.add(cnt);
                }
            }
        }

        System.out.println(result.size()); // 총 단지 수
        Collections.sort(result);
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }

    private static void dfs(int x, int y) {
        visited[x][y] = true;
        cnt++;
        int[] xx = {1, -1, 0, 0};
        int[] yy = {0, 0, 1, -1};

        for (int i = 0; i < 4; i++) {
            int dx = x + xx[i];
            int dy = y + yy[i];

            if (isValid(dx, dy) && !visited[dx][dy] && matrix[dx][dy] == 1) {
                dfs(dx, dy);
            }
        }
    }

    static boolean isValid(int dx, int dy) {
        return (dx >= 0 && dx < n && dy >= 0 && dy < n);
    }

}
