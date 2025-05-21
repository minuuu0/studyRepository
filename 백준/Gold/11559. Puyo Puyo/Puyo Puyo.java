import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] board;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};
    static boolean[][] visited;
    static ArrayList<Node> list;
    static int n = 12, m = 6;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 1. init
        board = new char[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        int cnt = 0;
        while (true) {
            boolean isFinished = true;
            visited = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] != '.') {
                        list = new ArrayList<>();
                        bfs(board[i][j], i, j);

                        if (list.size() >= 4) {
                            isFinished = false; // 연쇄가 일어났으므로 더 탐색해야함
                            for (int k = 0; k < list.size(); k++) {
                                board[list.get(k).x][list.get(k).y] = '.'; // 터트리기
                            }
                        }
                    }
                }
            }
            if (isFinished) break;
            fallPuyos();
            cnt++;
        }
        System.out.println(cnt);

    }

    private static void fallPuyos() {
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j > 0; j--) {
                if (board[j][i] == '.') {
                    for (int k = j - 1; k >= 0; k--) {
                        if (board[k][i] != '.') {
                            board[j][i] = board[k][i];
                            board[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    private static void bfs(char c, int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        list.add(new Node(x, y));
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && board[nx][ny] == c) {
                    visited[nx][ny] = true;
                    list.add(new Node(nx, ny));
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


}