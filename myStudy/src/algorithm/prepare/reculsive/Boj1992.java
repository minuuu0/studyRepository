package algorithm.prepare.reculsive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1992 {

    static int[][] board;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        recul(0, 0, N);
        System.out.println(sb);
    }

    private static void recul(int x, int y, int n) {
        if (isSame(x, y, n)) {
            sb.append(board[x][y]);
            return;
        }

        n = n / 2;
        sb.append("(");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                recul(x + i * n, y + j * n, n);
            }
        }
        sb.append(")");

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

/*
8
00000000
00000000
00001111
00001111
00011111
00111111
00111111
00111111
 */