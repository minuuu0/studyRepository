

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[][] board;
    static int[][] board2;
    static ArrayList<CCTV> cctvList = new ArrayList<>();

    // 남, 동, 북, 서
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        N = Integer.parseInt(s.nextToken());
        M = Integer.parseInt(s.nextToken());
        board = new int[N][M];
        board2 = new int[N][M];
        int mn = 0;

        for (int i = 0; i < N; i++) {
            s = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(s.nextToken());
                if (board[i][j] != 0 && board[i][j] != 6) {
                    cctvList.add(new CCTV(i, j));
                }
                if (board[i][j] == 0) mn++;
            }
        }

        // 모든 경우의 수 뽑기
        for (int d = 0; d < (1 << (2 * cctvList.size())); d++) {
            // 마킹 초기화
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    board2[i][j] = board[i][j];
                }
            }

            int brute = d;

            // cctv 좌표 담고 upd 함수로 넘기기
            for (int i = 0; i < cctvList.size(); i++) {
                int dir = brute % 4;
                brute /= 4;
                int x = cctvList.get(i).x;
                int y = cctvList.get(i).y;
                if (board[x][y] == 1) {
                    upd(x, y, dir);
                } else if (board[x][y] == 2) { // 반대 이동 (0,2) (1, 3)이 되도록
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
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (board2[i][j] == 0) {
                        val++;
                    }
                }
            }
            mn = Math.min(mn, val);
        }
        System.out.println(mn);

    }

    static void upd(int x, int y, int dir) {
        dir %= 4;
        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (OOB(x, y) || board2[x][y] == 6) {
                return;
            }
            if (board2[x][y] != 0) continue;
            board2[x][y] = 7; // 7로 마킹
        }

    }

    // 범위를 나가면 참
    static boolean OOB(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= M;
    }
    static class CCTV {
        int x;
        int y;

        CCTV(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
