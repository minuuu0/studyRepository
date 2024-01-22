package algorithm.baekjoon.foundation.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1080 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrix = new int[n][m];
        int[][] goal = new int[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                matrix[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                goal[i][j] = str.charAt(j) - '0';
            }
        }
        int cnt = 0;

        // O(n * m) * 3 * 3
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                if (matrix[i][j] != goal[i][j]) {
                    cnt++;
                    for (int k = i; k < i + 3; k++) {
                        for (int l = j; l < j + 3; l++) {
                            matrix[k][l] = matrix[k][l] == 0 ? 1 : 0; // 0 -> 1, 1 -> 0
                        }
                    }
                }
            }

        }

        if (Arrays.deepEquals(matrix, goal)) {
            System.out.println(cnt);
        } else {
            System.out.println(-1);
        }


    }

}
