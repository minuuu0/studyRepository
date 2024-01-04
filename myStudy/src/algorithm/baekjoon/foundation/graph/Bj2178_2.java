package algorithm.baekjoon.foundation.graph;

import java.io.*;
import java.util.*;

public class Bj2178_2 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(map[n - 1][m - 1]);


    }

    static void bfs(int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};


        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (isValid(nextX, nextY) && map[nextX][nextY] == 1) {
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                    que.add(new int[]{nextX, nextY});
                }
            }
        }

    }

    static boolean isValid(int nextX, int nextY) {
        return nextX >= 0 && nextX < n && nextY >= 0 && nextY < m;
    }

}
