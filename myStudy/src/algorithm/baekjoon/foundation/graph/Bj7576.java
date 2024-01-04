package algorithm.baekjoon.foundation.graph;

import java.io.*;
import java.util.*;
public class Bj7576 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    static int[][] map;
    static Queue<int[]> que = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0; // 모두 1인지 확인

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    que.add(new int[]{i, j});
                    cnt++;
                }
            }
        }

        if (cnt == n * m) { // 모두 1인 경우엔 0 출력후 종료
            System.out.println(0);
            return;
        }

        int result = bfs();
        System.out.println(result);

    }

    private static int bfs() {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!que.isEmpty()) { // 탐색 시작
            int[] poll = que.poll(); // 큐에는 1인 값들이 들어가 있다.
            int nowX = poll[0];
            int nowY = poll[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                if (isValid(nextX, nextY) && map[nextX][nextY] == 0) { // 주변이 익지 않은 경우
                    que.add(new int[]{nextX, nextY});
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                }
            }

        }

        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) {
                    return -1;
                }
                else{
                    cnt = Math.max(map[i][j], cnt);
                }
            }
        }
        return cnt - 1;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }

}
