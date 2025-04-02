package algorithm.prepare.reculsive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2447 {

    static char[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];

        func(n, 0, 0, false);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static void func(int n, int x, int y, boolean blank) {

        if (blank) {
            for (int i = x; i < n + x; i++) {
                for (int j = y; j < n + y; j++) {
                    board[i][j] = ' ';
                }
            }
            return;
        }

        if (n == 1) {
            board[x][y] = '*';
            return;
        }

        int size = n / 3;
        int cnt = 0;
        for (int i = x; i < n + x; i += size) {
            for (int j = y; j < n + y; j += size) {
                cnt++;
                if (cnt == 5) func(size, i, j, true);
                else func(size, i, j, false);
            }
        }

    }

}
