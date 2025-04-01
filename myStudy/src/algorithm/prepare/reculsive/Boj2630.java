package algorithm.prepare.reculsive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2630 {

    static int[][] board;
    static int[] cnt = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer s = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(s.nextToken());
            }
        }

        func(0, 0, n);
        for (int res : cnt) {
            System.out.println(res);
        }

    }

    static void func(int x, int y, int n) {
        if (isSame(x, y, n)) {
            cnt[board[x][y]] += 1;
            return;
        }

        n = n / 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                func(x + i * n, y + j * n, n);
            }
        }

    }

    private static boolean isSame(int x, int y, int n) {
        for (int i = x; i < n + x; i++) {
            for (int j = y; j < n + y; j++) {
                if (board[x][y] != board[i][j]) return false;
            }
        }
        return true;
    }

}
