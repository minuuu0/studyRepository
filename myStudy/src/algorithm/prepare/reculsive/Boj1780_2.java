package algorithm.prepare.reculsive;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1780_2 {

    static int[][] board;
    static int[] result = new int[3];

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

        func(n, 0, 0);
        for (int res : result) {
            System.out.println(res);
        }

    }

    static void func(int n, int x, int y) {
        if (isSame(x, y, n)) {
            result[board[x][y] + 1] += 1;
            return;
        }

        n = n / 3;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                func(n, x + i * n, y + j * n);
            }
        }
    }

    static boolean isSame(int x, int y, int n) {
        int temp = board[x][y];
        for (int i = x; i < n + x; i++) {
            for (int j = y; j < n + y; j++) {
                if (temp != board[i][j]) return false;
            }
        }
        return true;
    }

}
