import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {

    static char[][] board = new char[5][5]; // 0 : 'S'       ,      1 : 'Y'
    static int cnt = 0;
    static boolean[] totalVisited = new boolean[25];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException{
        // initialize
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 5; i++) {
            String temp = br.readLine();
            for (int j = 0; j < 5; j++) {
                board[i][j] = temp.charAt(j);
            }
        }
        // logic
        comb(0, 0, 0);
        // result
        System.out.println(cnt);
    }

    static void comb(int depth, int start, int yCnt) {
        // 임도연파가 4명 이상이면 실패한 조합.
        if (yCnt >= 4) {
            return;
        }

        // 조합을 완성 시켰을 때
        if (depth == 7) {
            int curIdx = start - 1;
            int x = curIdx / 5;
            int y = curIdx % 5;
            if (bfs(x, y)) {
                cnt++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            totalVisited[i] = true;

            if (board[i / 5][i % 5] == 'Y') {
                comb(depth + 1, i + 1, yCnt + 1);
            } else {
                comb(depth + 1, i + 1, yCnt);
            }

            totalVisited[i] = false;
            
        }
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        visited[x][y] = true;
        
        queue.offer(new int[] {x, y});

        int cntGirl = 1; // 연결된 여학생의 수
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur[0] + dx[i];
                int ny = cur[1] + dy[i];
                int nxt = nx * 5 + ny;
                if (isValid(nx, ny) && !visited[nx][ny] && totalVisited[nxt]) {
                    visited[nx][ny] = true;
                    queue.offer(new int[] {nx, ny});
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