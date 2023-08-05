package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj3085 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int maxCandy = 1;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        char[][] arr = new char[n][n];

        for(int i = 0; i < n; i++){
            String s = br.readLine();

            for(int j = 0; j < n; j++){
                arr[i][j] = s.charAt(j);
            }
        }

        // 행 기준 오른쪽
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1; j++) {
                // 현재 위치와 오른쪽 위치의 사탕이 다른 경우
                if (arr[i][j] != arr[i][j + 1]) {
                    // 사탕 교환
                    char temp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = temp;

                    // 사탕 개수 세기
                    findMaxCandy(arr);

                    // 사탕 복구
                    temp = arr[i][j];
                    arr[i][j] = arr[i][j + 1];
                    arr[i][j + 1] = temp;
                }
            }
        }

        // 행 기준 아래쪽
        for(int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n; j++) {
                // 현재 위치와 오른쪽 위치의 사탕이 다른 경우
                if (arr[i][j] != arr[i + 1][j]) {
                    // 사탕 교환
                    char temp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = temp;

                    // 사탕 개수 세기
                    findMaxCandy(arr);

                    // 사탕 복구
                    temp = arr[i][j];
                    arr[i][j] = arr[i + 1][j];
                    arr[i + 1][j] = temp;
                }
            }
        }

        System.out.println(maxCandy);

    }

    private static void findMaxCandy(char[][] arr) {
        int N = arr.length;

        // 행에서 긴 수열 탐색
        for (int i = 0 ; i < N; i ++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] == arr[i][j + 1]) {
                    count++;
                    maxCandy = Math.max(count, maxCandy);
                } else {
                    count = 1;
                }
            }
        }

        // 열에서 긴 수열 탐색
        for (int i = 0 ; i < N; i ++) {
            int count = 1;

            for (int j = 0; j < N - 1; j++) {
                if (arr[j][i] == arr[j + 1][i]) {
                    count++;
                    maxCandy = Math.max(count, maxCandy);
                } else {
                    count = 1;
                }
            }
        }
    }

}
