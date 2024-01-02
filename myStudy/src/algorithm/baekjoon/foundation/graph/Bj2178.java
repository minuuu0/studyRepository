package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int result = dfs(0, 0);
        System.out.println(result);

    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;

        if (x == n - 1 && y == m - 1) { // 0based 기준으로 도착지 도착시 1리턴
            return 1;
        }

        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int mindist = Integer.MAX_VALUE;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (isValid(nx, ny) && !visited[nx][ny] && map[nx][ny] == 1) {
                int dist = dfs(nx, ny);
                if (dist != -1) { // 더이상 찾을 경로가 없다면 최소값 계산을 해준다.
                    mindist = Math.min(mindist, dist + 1); // 지금까지 탐색한 노드의 수 + 1과 최소값 비교
                }
            }
        }

        if (mindist == Integer.MAX_VALUE) { // 찾을 경로가 없는 경우
            return -1; // No path found
        }

        return mindist; // 지금까지 탐색한 노드의 수를 리턴
    }

    private static boolean isValid(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }

}

