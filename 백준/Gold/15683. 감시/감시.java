import java.lang.*;
import java.io.*;
import java.util.*;

class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int n, m;
    static int[][] board;
    static int[][] board2;
    static int mn = 0;
    static List<Cctv> cctvList = new ArrayList<>();

    static int[] dx = {-1, 0, 1, 0}; // 하 상 우 좌
    static int[] dy = {0, 1, 0, -1};


    public static void main (String[] args) throws IOException
    {
        // 1. 모든 조합을 순회한다.
        // 2. n, m을 순회하며 cctv를 만날 때마다 재귀 함수를 호출한다.
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        board2 = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board2[i][j] = Integer.parseInt(st.nextToken());
                if (board2[i][j] != 0 && board2[i][j] != 6) cctvList.add(new Cctv(i, j));
                if (board2[i][j] == 0) mn++;
            }
        }

        solve();
    }

    static void solve() {

        int comb = (int) Math.pow(4, cctvList.size());
        for (int c = 0; c < comb; c++) {

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    board[i][j] = board2[i][j];
                }
            }

            // 모든 경우에 대해
            int brute = c;
            for (int i = 0; i < cctvList.size(); i++) {
                int x = cctvList.get(i).x;
                int y = cctvList.get(i).y;

                // cctv의 방향 뽑기
                int dir = brute % 4;
                brute /= 4;

                // 하 상 우 좌
                if (board[x][y] == 1) {
                    upd(x, y, dir);
                } else if (board[x][y] == 2) {
                    upd(x, y, dir);
                    upd(x, y, dir + 2);
                } else if (board[x][y] == 3) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                } else if (board[x][y] == 4) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                } else {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                    upd(x, y, dir + 3);
                }
            }
            int val = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 0) {
                        val++;
                    }
                }
            }
            mn = Math.min(mn, val);
        }
        System.out.println(mn);
    }

    private static void upd(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (!OOB(x, y) || board[x][y] == 6) {
                return;
            }
            // cctv는 건너뛸 수 있다.
            if (board[x][y] != 0) continue;
            board[x][y] = 7;

        }
    }

    private static boolean OOB(int x, int y) {
        return x >= 0 && y >= 0 && x < n && y < m;
    }

    static class Cctv {
        int x;
        int y;

        Cctv(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}