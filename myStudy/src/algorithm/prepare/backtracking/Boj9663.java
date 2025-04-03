package algorithm.prepare.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj9663 {
    static int cnt, n;
    static boolean[] used1;
    static boolean[] used2;
    static boolean[] used3;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        used1 = new boolean[n];
        used2 = new boolean[n + n - 1];
        used3 = new boolean[n + n - 1];
        back(0);
        System.out.println(cnt);
    }

    static void back(int depth) {
        if (depth == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used1[i] || used2[i + depth] || used3[depth + n - i - 1]) {
                continue;
            }
            used1[i] = true;
            used2[i + depth] = true;
            used3[depth + n - i - 1] = true;
            back(depth + 1);
            used1[i] = false;
            used2[i + depth] = false;
            used3[depth + n - i - 1] = false;
        }
    }
}
