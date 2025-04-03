package algorithm.prepare.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1182 {

    static int N, S;
    static int[] board;
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(br.readLine());
        N = Integer.parseInt(s.nextToken());
        S = Integer.parseInt(s.nextToken());
        board = new int[N];

        s = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(s.nextToken());
        }
        sum(0, 0);
        if (S == 0) cnt--;
        System.out.println(cnt);
    }

    static void sum(int cur, int tot) {
        if (cur == N) {
            if (tot == S) {
                cnt++;
            }
            return;
        }

        sum(cur + 1, tot);
        sum(cur + 1, tot + board[cur]);
    }

}
