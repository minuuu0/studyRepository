

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N; //보드의 크기
    static int[][] board, board2;

    // 북 동 남 서
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    // 1. 게임판을 상하좌우로 기울이기
    // 2. 5번 기울이는 각각의 방향 정하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        board2 = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(s.nextToken());
            }
        }

        int mx = 0;
        for (int tmp = 0; tmp < 1024; tmp++) { // 최대 5번 움직일 수 있으니 4^5
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    board2[i][j] = board[i][j];
                }
            }

            int brute = tmp;
            for (int i = 0; i < 5; i++) {
                int dir = brute % 4;
                brute /= 4;
                tilt(dir);
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    mx = Math.max(mx, board2[i][j]);
                }
            }
        }
        System.out.println(mx);
    }

    // 기울이는 함수
    static void tilt(int dir) {
        while (dir-- > 0) rotate();
        for (int i = 0; i < N; i++) {
            int[] tilted = new int[21];
            int idx = 0;
            for (int j = 0; j < N; j++) {
                if (board2[i][j] == 0) continue;
                if (tilted[idx] == 0) tilted[idx] = board2[i][j];
                else if (tilted[idx] == board2[i][j]) tilted[idx++] *= 2;
                else tilted[++idx] = board2[i][j];
            }

            for (int j = 0; j < N; j++) board2[i][j] = tilted[j];
            
        }
        
    }

    // 회전시키는 함수
    static void rotate() {
        int tmp[][] = new int[21][21];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                tmp[i][j] = board2[i][j];
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board2[i][j] = tmp[N - 1 - j][i];
            }
        }
    }

    /*
    static void tilt1d() {
        int[] arr = {0, 2, 0, 2, 8, 8, 0, 16};
        int[] tilted = new int[8];
        int idx = 0;
        for (int i = 0; i < 8; i++) {
            if (arr[i] == 0) continue;
            if (tilted[idx] == 0) tilted[idx] = arr[i];
            else if (tilted[idx] == arr[i]) tilted[idx++] *= 2;
            else tilted[++idx] = arr[i];
        }

    }
     */

    /*
    static void tilt1d() {
        int[] arr = {0, 2, 0, 2, 8, 8, 0, 16};
        int[] titled = new int[8];
        boolean[] merged = new boolean[8];

        for (int i = 0; i < 8; i++) {
            if (arr[i] == 0) continue;
            // titled에 첫 원소를 채움
            if (titled[0] == 0) {
                titled[0] = arr[i];
                continue;
            }

            int idx = i;
            while (titled[idx] == 0) idx--;
            if (!merged[idx] && titled[idx] == arr[i]) {
                merged[idx] = true;
                titled[idx] *= 2;
            }
            else titled[idx + 1] = arr[i];
        }

    }
    */
}
