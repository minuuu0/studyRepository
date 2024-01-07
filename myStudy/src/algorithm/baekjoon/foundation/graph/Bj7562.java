package algorithm.baekjoon.foundation.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj7562 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int i;
    static int[][] chessBoard;

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        while (testCase-- > 0) {
            i = Integer.parseInt(br.readLine()); // 체스판 한 변의 길이
            StringTokenizer st = new StringTokenizer(br.readLine()); // 나이트가 있는 현재 칸
            chessBoard = new int[i][i];

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine()); // 나이트가 가고 싶은 칸
            int goalX = Integer.parseInt(st.nextToken());
            int goalY = Integer.parseInt(st.nextToken());

            int cnt = bfs(x, y, goalX, goalY);
            System.out.println(cnt);

        }
    }

    private static int bfs(int x, int y, int goalX, int goalY) {
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});


        int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
        int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
        int count = 0;

        while (!que.isEmpty()) {
            int[] poll = que.poll();
            int nowX = poll[0];
            int nowY = poll[1];

            if (nowX == goalX && nowY == goalY) {
                return count;
            }

            for (int i = 0; i < 8; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (isValid(nextX, nextY)) {
                    que.add(new int[]{nextX, nextY});
                }
            }
        }
        return count;
    }

    private static boolean isValid(int nextX, int nextY) {
        return nextX >= 0 && nextX < i && nextY >= 0 && nextY < i;
    }

}
