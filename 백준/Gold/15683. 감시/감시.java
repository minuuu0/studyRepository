import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n, m;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int[][] board = new int[12][12];
    static int[][] board2 = new int[12][12];
    static List<CCTV> cctvList = new ArrayList<>();
    static int min = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 0 && board[i][j] != 6) {
                    cctvList.add(new CCTV(i, j));
                }
                if (board[i][j] == 0) min++;
            }
        }
        // 모든 CCTV 방향의 모든 경우의 수를 뽑는다. -> 4가지의 방향으로 CCTV최대 8개이기에 4^8의 경우의 수이니 시간복잡도도 문제없다.
        // 모든 cctv에 대해 사각지대를 만들고 갱신한다 (NM) = 64 -> 6만 x 64 = 충분함
        // 만약 CCTV의 개수가 3개라면 4^3 = 64가지인데 0 ~ 63의 수에서 4로 나머지 연산을 계속한다면 0,1,2,3 네가지 방향을 조절할 수 있다.
        for (int i = 0; i < (1 << (cctvList.size() * 2)); i++) {
            int brute = i;

            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    board2[j][k] = board[j][k];
                }
            }

            for (int j = 0; j < cctvList.size(); j++) {
                // 각 CCTV에 대해 방향마다 사각지대를 갱신하자 ex) 3개의 각 방향을 생성함
                int dir = brute % 4;
                brute /= 4;
                CCTV cctv = cctvList.get(j);
                int x = cctv.x;
                int y = cctv.y;
                if (board[x][y] == 1) {
                    upd(x, y, dir);
                } else if (board[x][y] == 2) {
                    upd(x, y, dir);
                    upd(x, y, dir + 2);
                } else if (board[x][y] == 3) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                } else if (board[x][y] == 4) {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                } else {
                    upd(x, y, dir);
                    upd(x, y, dir + 1);
                    upd(x, y, dir + 2);
                    upd(x, y, dir + 3);
                }
            }

            // 갱신
            int temp = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (board2[j][k] == 0) {
                        temp++;
                    }
                }
            }
            min = Math.min(min, temp);

        }
        System.out.println(min);
    }

    private static void upd(int x, int y, int dir) {
        // 모든 board를 마킹하여 갱신하기
        dir %= 4;

        while (true) {
            x += dx[dir];
            y += dy[dir];
            if (!isValid(x, y) || board2[x][y] == 6) {
                break;
            }
            board2[x][y] = 7;
        }

    }

    private static boolean isValid(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < m;
    }

    static class CCTV{
        int x;
        int y;
        CCTV(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    
}
