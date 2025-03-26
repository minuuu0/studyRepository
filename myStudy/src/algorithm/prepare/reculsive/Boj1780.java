package algorithm.prepare.reculsive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1780 {

    static int[][] board;
    static int[] cnt = new int[3]; // -1, 0, 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(s.nextToken());
            }
        }

        recul(0, 0, N);

        for (int i = 0; i < cnt.length; i++) {
            System.out.println(cnt[i]);
        }

    }

    private static void recul(int x, int y, int n) {
        if (isSame(x, y, n)) {
            cnt[board[x][y] + 1] += 1;
            return;
        }

        n = n / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                recul(x + i * n, y + j * n, n);
            }
        }
    }

    static boolean isSame(int x, int y, int n) {
        int check = board[x][y];
        for (int i = x; i < x + n; i++) {
            for (int j = y; j < y + n; j++) {
                if (board[i][j] != check) return false;
            }
        }
        return true;
    }


}
