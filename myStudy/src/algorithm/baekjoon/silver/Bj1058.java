package algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Bj1058 {
    static int n;
    static char[][] friend;
    static boolean[][] isFriend; // 친구 여부 기록
    static int maxConunt = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        friend = new char[n][n];
        isFriend = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                friend[i][j] = str.charAt(j);
            }
        }

        int max = Integer.MIN_VALUE; // 가장 많은 친구 보관

        for (int i = 0; i < n; i++) {
            int twoFriend = 0;
            for (int j = 0; j < n; j++) {
                // 모든 원소 순회
                if (friend[i][j] == 'Y') {
                    isFriend[i][j] = true; // 친구 표시
                    for (int k = 0; k < n; k++) { // 친구의 세로를 탐색함
                        if (friend[j][k] == 'Y') isFriend[i][k] = true;
                    }
                }
            }

            for (int j = 0; j < n; j++) {
                if (j == i) continue;
                if (isFriend[i][j]) twoFriend++;
            }
            max = Math.max(max, twoFriend);
        }
        System.out.println(max);
    }


}
