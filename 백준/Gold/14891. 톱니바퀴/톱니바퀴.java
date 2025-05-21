import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] cogWheel = new int[4][8];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            String str = br.readLine();
            for (int j = 0; j < 8; j++) {
                cogWheel[i][j] = str.charAt(j) - '0';
            }
        }
        int k = Integer.parseInt(br.readLine()); // 회전 횟수

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            solve(idx, dir);
        }

        int total =0;
        for(int i=0; i<4; i++) {
            total += Math.pow(2, i)*cogWheel[i][0];
        }
        System.out.println(total);

    }

    private static void solve(int idx, int dir) {
        // 좌측 방향
        leftSide(idx-1, -dir);
        // 오른쪽 (idx+1 ~ 3)
        rightSide(idx+1, -dir);
        rotate(idx,dir);
    }

    private static void rightSide(int idx, int dir) {
        if(idx > 3) return;
        if(cogWheel[idx][6] == cogWheel[idx-1][2]) return;
        rightSide(idx+1, -dir);
        rotate(idx,dir);
    }

    private static void leftSide(int idx, int dir) {
        if(idx < 0) return;
        if(cogWheel[idx][2]==cogWheel[idx+1][6]) return;
        leftSide(idx-1, -dir);
        rotate(idx,dir);
    }

    private static void rotate(int idx, int dir) {

        if (dir == 1) {
            // 시계 방향으로 회전
            int tmp = cogWheel[idx][7];
            for(int i = 7; i > 0; i--) {
                cogWheel[idx][i] = cogWheel[idx][i - 1];
            }
            cogWheel[idx][0] = tmp;
        } else {
            // 반시계 방향으로 회전
            int tmp = cogWheel[idx][0];
            for (int i = 0; i < 7; i++) {
                cogWheel[idx][i] = cogWheel[idx][i + 1];
            }
            cogWheel[idx][7] = tmp;
        }
    }

}