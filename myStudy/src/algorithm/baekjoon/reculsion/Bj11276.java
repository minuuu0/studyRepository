package algorithm.baekjoon.reculsion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj11276 {
    static int[][] board;
    static int[] temp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            // 초기화
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 배열의 크기 (500)
            int d = Integer.parseInt(st.nextToken()); // 각도

            board = new int[n][n];
            temp = new int[n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 주요 로직
            for (int i = 0; i < Math.abs(d) / 45; i++) {
                if (d > 0) {
                    right();
                } else {
                    left();
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        }
    }

    public static void right() {
        int mid = n / 2;
        // 중간 점 잡기
        // 주 대각선 변환

        // 임시 보관함에 주 대각선 복사 (주대각선을 제일 마지막에 변화시켜야 올바르게 가능)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    temp[i] = board[i][j];
                }
            }
        }

        // 1. 가로직선 -> 주대각선
        for (int i = 0; i < n; i++) {
            board[i][i] = board[mid][i];
        }


        // 2. 부대각선 -> 가로직선
        for (int i = 0; i < n; i++) {
            board[mid][i] = board[n - 1 - i][i]; // 기존 가로 직선은 대각선으로 변환한다.
        }


        // 3. 세로 -> 부대각선
        for (int i = 0; i < n; i++) {
            board[i][n - 1 - i] = board[i][mid];
        }


        // 4. temp -> 세로
        for (int i = 0; i < n; i++) {
            board[i][mid] = temp[i];
        }
    }

    public static void left() {
        int mid = n / 2;
        // 중간 점 잡기
        // 주 대각선 변환

        // 임시 보관함에 주 대각선 복사 (주대각선을 제일 마지막에 변화시켜야 올바르게 가능)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    temp[i] = board[i][j];
                }
            }
        }

        // 1. 세로직선 -> 주대각선
        for (int i = 0; i < n; i++) {
            board[i][i] = board[i][mid];
        }


        // 2. 부대각선 -> 세로직선
        for (int i = 0; i < n; i++) {
            board[i][mid] = board[i][n - 1 - i]; // 기존 가로 직선은 대각선으로 변환한다.
        }


        // 3. 가로직선 -> 부대각선
        for (int i = 0; i < n; i++) {
            board[n - 1 - i][i] = board[mid][i];
        }


        // 4. temp -> 가로직선
        for (int i = 0; i < n; i++) {
            board[mid][i] = temp[i];
        }

    }

}
