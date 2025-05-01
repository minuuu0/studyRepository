import java.lang.*;
import java.io.*;
import java.util.*;

class Main
{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    // 1. 스티커를 붙일 수 있는 위치 찾기
    // 2. 만약 붙일 수 없다면 90도 회전을 네 번 반복
    static int n, m, k; // n, m : 노트북의 가로 세로 길이(40) / k : 스티커의 개수(100)
    static int r, c;
    static int[][] board; // 스티커를 담을 배열
    static int[][] notebook;

    public static void main (String[] args) throws IOException
    {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        notebook = new int[n][m];

        for (int l = 0; l < k; l++) {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            board = new int[12][12];
            for (int j = 0; j < r; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < c; k++) {
                    board[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            boolean flag = false;
            // 1. 스티커를 붙일 수 있는지 찾는다. -> 모든 노트북 자리를 순회하며 확인 복잡도 (nm) * k = 160000으로 충분
            for (int rot = 0; rot < 4; rot++) {
                for (int i = 0; i <= n - r; i++) {
                    for (int j = 0; j <= m - c; j++) {
                        if (pastable(i, j)) {
                            // 스티커를 붙였다면 다음 스티커로 넘어가야한다 다만 rot도 넘어가야하기에 flag를 이용하자
                            flag = true;
                            break;
                        }
                    }
                    if (flag) break;
                }
                if (flag) break;
                // 만약 붙일 수 없다면 회전시킨다
                rotate();
            }
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                cnt += notebook[i][j];
            }
        }
        System.out.println(cnt);

    }

    private static void rotate() {
        // 스티커를 회전한다는 것은 쉽게 말해 배열을 회전시키면 되는 것이다.
        int[][] newBoard = new int[12][12];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                newBoard[i][j] = board[i][j];
            }
        }
        // board 배열 변경
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                board[i][j] = newBoard[r - 1 - j][i];
            }
        }
        int temp = r;
        r = c;
        c = temp;
    }

    private static boolean pastable(int x, int y) {
        // x, y :

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (notebook[i + x][j + y] == 1 && board[i][j] == 1) { // 스티커를 붙이려고 하는데(board) 노트북에 이미 있다면 해당 좌표에선 붙일 수 없다는 것이다.
                    return false;
                }
            }
        }

        // 스티커를 붙일 수 있으니 스티커를 붙인다
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (board[i][j] == 1) {
                    notebook[x + i][y + j] = 1;
                }
            }
        }
        return true;
    }


}