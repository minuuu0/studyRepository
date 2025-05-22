import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m, x, y, k;
    static int[][] map;
    static int[] row = new int[4];
    static int[] col = new int[4];
    static int[] dx = {0, 0, 0, -1, 1};
    static int[] dy = {0, 1, -1, 0, 0}; // 1 : 동쪽 / 2 : 서쪽 / 3: 북쪽 / 4 : 남쪽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken()) + 1;
        y = Integer.parseInt(st.nextToken()) + 1;
        k = Integer.parseInt(st.nextToken());

        map = new int[n + 2][m + 2];

        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(map[i], -1);
        }

        // 지도에 쓰여진 수 입력
        // 1based
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 방향 받기
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) { // 방향별로 이동 시작
            int dir = Integer.parseInt(st.nextToken());
            x += dx[dir];
            y += dy[dir];

            if (map[x][y] != -1) {
                if (dir == 1 || dir == 2) { // 동쪽과 서쪽인 경우
                    if (dir == 1) {
                        int temp = row[0];
                        for (int j = 0; j < 3; j++) { // 가로면의 순서를 섞음
                            row[j] = row[j + 1];
                        }
                        row[3] = temp;
                        col[1] = row[1];
                        col[3] = row[3];
                    } else { // 서쪽
                        int temp = row[3];
                        for (int j = 3; j > 0; j--) {
                            row[j] = row[j - 1];
                        }
                        row[0] = temp;
                        col[1] = row[1];
                        col[3] = row[3];
                    }
                    rowPrint(x, y);
                } else { // 북쪽과 남쪽인 경우
                    if (dir == 3) {
                        int temp = col[0];
                        for (int j = 0; j < 3; j++) {
                            col[j] = col[j + 1];
                        }
                        col[3] = temp;
                        row[1] = col[1];
                        row[3] = col[3];
                    } else {
                        int temp = col[3];
                        for (int j = 3; j > 0; j--) {
                            col[j] = col[j - 1];
                        }
                        col[0] = temp;
                        row[1] = col[1];
                        row[3] = col[3];
                    }
                    colPrint(x, y);
                }
            } else {
                x -= dx[dir]; // 넘었으면 되돌아감
                y -= dy[dir];
            }
        }

    }

    private static void colPrint(int i, int j) {
        if (map[i][j] == 0) {
            map[i][j] = col[1];
            row[1] = col[1];
        } else {
            col[1] = map[i][j];
            row[1] = col[1];
            map[i][j] = 0;
        }
        System.out.println(col[3]);
    }

    private static void rowPrint(int i, int j) {
        if (map[i][j] == 0) { // 지도의 해당 칸이 비어있으면 바닥면의 숫자를 지도에 복사
            map[i][j] = row[1]; // 바닥면 복사
            col[1] = row[1];
        } else {    // 비어 있지 않다면 칸의 수가 바닥면으로 복사 후 칸은 0으로
            row[1] = map[i][j];
            col[1] = row[1];
            map[i][j] = 0;
        }
        System.out.println(row[3]);
    }


}