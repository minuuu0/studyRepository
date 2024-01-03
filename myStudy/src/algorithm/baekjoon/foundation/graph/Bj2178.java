package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj2178 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] map;
    static int min = Integer.MAX_VALUE;
    static boolean[][] visited;
    static int n, m;
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String road = br.readLine();
            for (int j = 0; j < m; j++) {
                map[i][j] = road.charAt(j) - '0';
            }
        }

        bfs(0, 0);
//        dfs(0, 0, 1);
        System.out.println(map[n-1][m-1]);
//        System.out.println(min);
    }

    private static void bfs(int x, int y) {  // 각 노드에 대해 한번만 방문하니 O(N * M) .. 근데 dfs도 결국 필터링하니 O(N * M)아닌가..?
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        visited[x][y] = true;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!queue.isEmpty()) {  // O(N * M)
            int[] poll = queue.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            for (int i = 0; i < 4; i++) { // O(4)
                int nx = dx[i] + nowX;
                int ny = dy[i] + nowY;

                if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                    queue.add(new int[]{nx, ny});
                    map[nx][ny] = map[nowX][nowY] + 1;
                    visited[nx][ny] = true;
                }
            }

        }

    }


    private static void dfs(int x, int y, int count) { // 지피티 왈 worst의 경우 : O(4^(n*m))??? -> 근데 중복한걸 필터링하니 O(N*M)아닌가..
        visited[x][y] = true;

        if (x == n - 1 && y == m - 1) { // 0based 기준으로 도착지 도착시 1리턴
            min = Math.min(min, count);
            return;
        }

        if(count > min) return; // 가지치기

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};


        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                visited[nx][ny] = true;
                dfs(nx, ny, count + 1); // O(4n)
                visited[nx][ny] = false;
            }
        }
    }

    private static boolean isValid(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }

}

