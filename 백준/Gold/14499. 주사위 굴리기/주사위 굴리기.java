import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] dice = new int[6];
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + dx[dir - 1];
            int ny = y + dy[dir - 1];
//            System.out.println("nx : " + nx +" ny : " + ny);
            if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                x = nx;
                y = ny;
                roll(dir);
                if (board[nx][ny] == 0) {
                    board[nx][ny] = dice[3];
                } else {
                    dice[3] = board[nx][ny];
                    board[nx][ny] = 0;
                }
                System.out.println(dice[0]);

            }
        }

    }

    private static void roll(int dir) {
        int temp0 = dice[0], temp1 = dice[1], temp2 = dice[2];
        int temp3 = dice[3], temp4 = dice[4], temp5 = dice[5];

        if (dir == 1) {
            dice[0] = temp1; dice[1] = temp3; dice[2] = temp0;
            dice[3] = temp2; dice[4] = temp4; dice[5] = temp5;
        } else if (dir == 2) {
            dice[0] = temp2; dice[1] = temp0; dice[2] = temp3;
            dice[3] = temp1; dice[4] = temp4; dice[5] = temp5;
        } else if (dir == 3) {
            dice[0] = temp4; dice[1] = temp1; dice[2] = temp2;
            dice[3] = temp5; dice[4] = temp3; dice[5] = temp0;
        } else {
            dice[0] = temp5; dice[1] = temp1; dice[2] = temp2;
            dice[3] = temp4; dice[4] = temp0; dice[5] = temp3;
        }
        /*
        System.out.println();
        System.out.println("주사위 결과");
        for (int i = 0; i < 6; i++) {
            System.out.print(dice[i] + " ");
        }
        System.out.println();*/
    }

}