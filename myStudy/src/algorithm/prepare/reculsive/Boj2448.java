package algorithm.prepare.reculsive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj2448 {
    static char[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        board = new char[n][n * 2 - 1];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], ' '); // 공백으로 채움
        }


        star(0, n - 1, n);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                sb.append(board[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static void star(int x, int y, int n) {
        if (n == 3) {
            board[x][y] = '*';
            board[x + 1][y - 1] = board[x + 1][y + 1] = '*';
            board[x + 2][y - 2] = board[x + 2][y - 1] = board[x + 2][y] = board[x + 2][y + 1] = board[x + 2][y + 2] = '*';
            return;
        } else {
            int cut = n / 2;
            star(x, y, cut);
            star(x + cut, y - cut, cut);
            star(x + cut, y + cut, cut);
        }
    }
}
