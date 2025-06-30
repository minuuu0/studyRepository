import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static final int n = 5;
    static int[][][] originBoard;
    static int[][][] board;
    static int[] orders = new int[n];
    static boolean[] visited = new boolean[n];
    static boolean[][][] visited2 = new boolean[n][n][n];
    static int minDis = Integer.MAX_VALUE;

    static int[] dx = {-1, 0, 1, 0, 0, 0};
    static int[] dy = {0, 1, 0, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        originBoard = new int[n][n][n];
        board = new int[n][n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 0; k < n; k++) {
                    originBoard[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        perm(0);
        System.out.println(minDis == Integer.MAX_VALUE ? -1 : minDis);
    }

    private static void perm(int depth) {

        // 1. 판을 쌓는 모든 경우의 수(5!) = 120
        if (depth == n) {
            // board에 모든 판을 쌓는 모든 경우의 수가 들어감 // 4 3 2 1 0 -> 0층(인덱스)에 4층 복사 / 1층에 3층복사.. 이렇게
            copyToBoard();
            // 이미 board를 바꿔놨으니 추후 회전은 board를 통해 수행해주면 된다.
            tryRotation(0);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                orders[depth] = i;
                perm(depth + 1);
                visited[i] = false;
            }
        }
    }

    private static void tryRotation(int depth) {
        // depth = 회전시킬 층
        if (depth == n) {
            // 모든 층을 회전 시켰다는 것이 됨.
            int dist = bfs();
            if (dist < minDis) minDis = dist;
            return;
        }

        for (int r = 0; r < 4; r++) { // 모든 층은 4번씩 회전 -> 5층이니 5^4의 시간복잡도
            rotate(depth);
            tryRotation(depth + 1);
        }
    }

    private static int bfs() {
        if (board[0][0][0] == 0 || board[n - 1][n - 1][n - 1] == 0)
            return Integer.MAX_VALUE;

        visited2 = new boolean[n][n][n];
        Queue<Pair> queue = new LinkedList<>();
        queue.offer(new Pair(0, 0, 0, 0));
        visited2[0][0][0] = true;

        while (!queue.isEmpty()) {
            Pair cur = queue.poll();
            if (cur.x == n - 1 && cur.y == n - 1 && cur.z == n - 1) {
                return cur.dist; // 도착하면 현재까지의 거리 리턴
            }

            for (int d = 0; d < 6; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                int nz = cur.z + dz[d];

                if (inRange(nx, ny, nz) && !visited2[nz][nx][ny] && board[nz][nx][ny] == 1) {
                    visited2[nz][nx][ny] = true;
                    queue.offer(new Pair(nx, ny, nz, cur.dist + 1));
                }
            }
        }

        return Integer.MAX_VALUE;
    }

    private static boolean inRange(int nx, int ny, int nz) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n && nz >= 0 && nz < n;
    }

    // 90도 회전
    private static void rotate(int z) {
        int[][] temp = new int[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                temp[x][y] = board[z][x][y];
            }
        }

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                board[z][x][y] = temp[n - 1 - y][x];
            }
        }
    }

    private static void printLayer(int[][] layer) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(layer[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printBoard() {
        for (int z = 0; z < n; z++) {
            System.out.println("=== board[" + z + "] ===");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[z][i][j] + " ");
                }
                System.out.println();
            }
        }
    }


    private static void copyToBoard() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    board[i][j][k] = originBoard[orders[i]][j][k]; // if orders = 0 1 2 4 3 -> 0번째 층에 0 / 1번째 층에 1 / 2번째 층에 2 / 3번째 층에 4 이렇게 가는거임
                }
            }
        }
    }
    


    static class Pair {
        int x, y, z, dist;

        public Pair(int x, int y, int z, int dist) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.dist = dist;
        }
    }
}