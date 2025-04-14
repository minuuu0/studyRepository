import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static char[][] board = new char[5][5];

    // totalVisited를 통해 재귀를 돌면서 탐색한 경우를 마킹하고, 인접한 여자들이 7명인지 확인해 인접했는지 파악할 수 있다.
    static boolean[] totalVisited = new boolean[25];
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = temp.charAt(j);
            }
        }

        func(0, 0, 0);
        System.out.println(cnt);
    }

    private static void func(int depth, int start, int yCnt) {
        if (yCnt >= 4) return;
        if (depth == 7) {
            if (isNear(start - 1)) {
                cnt++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            totalVisited[i] = true;

            int x = i / 5;
            int y = i % 5;
            if (board[x][y] == 'Y') {
                func(depth + 1, i + 1, yCnt + 1);
            } else {
                func(depth + 1, i + 1, yCnt);
            }
            totalVisited[i] = false;
        }
    }

    private static boolean isNear(int start) {
        int x = start / 5;
        int y = start % 5;
        boolean[][] visited = new boolean[5][5];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;

        int cntGirl = 1; // 연결된 여학생의 수
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            x = current[0];
            y = current[1];
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int next = nx * 5 + ny;
                if (isValid(nx, ny) && !visited[nx][ny] && totalVisited[next]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    cntGirl++;
                }
            }
        }
        return cntGirl == 7;
    }

    static boolean isValid(int x, int y) {
        return x >= 0 && x < 5 && y >= 0 && y < 5;
    }
}
