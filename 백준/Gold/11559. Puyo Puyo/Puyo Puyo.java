import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n = 12, m = 6;
    static char[][] board = new char[n][m];
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static boolean[][] visited;
    static List<Node> list;
    static int cnt = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                board[i][j] = str.charAt(j);
            }
        }

        // 뿌요게임은 4개의 연속된 값이 없을 때까지 반복함
        while (true) {
            visited = new boolean[n][m];
            boolean isFinished = true;  // 만약 제거될 뿌요가 있다면 false로 전환
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] != '.') {
                        list = new ArrayList<>();
                        bfs(i, j, board[i][j]);
                        if (list.size() >= 4) {
                            // 제거처리
                            isFinished = false; // 계속해서 뿌요 처리
                            for (int k = 0; k < list.size(); k++) {
                                board[list.get(k).x][list.get(k).y] = '.';
                            }
                        }
                    }
                }
            }
            if (isFinished) break;
            fallDown();
            cnt++;
        }
        System.out.println(cnt);
    }

    private static void fallDown() {
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

    private static void bfs(int x, int y, char target) {
        list.add(new Node(x, y));
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && board[nx][ny] == target) {
                    queue.offer(new Node(nx, ny));
                    visited[nx][ny] = true;
                    list.add(new Node(nx, ny));
                }
            }
        }
    }

    static class Node {
        int x;
        int y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}