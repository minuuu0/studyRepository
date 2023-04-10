package algorithm.baekjoon.step.bruteforce;

import java.util.Scanner;

public class Bj1018 {
    static final Scanner sc = new Scanner(System.in);
    private static int find(int i, int j, boolean[][] chess) {

        int cnt = 0;
        boolean TF = chess[i][j]; // 첫 번째 칸의 색을 기준으로

        for(int k = i; k < i + 8; k++){
            for(int l = j; l < j + 8; l++){
                if(chess[k][l] != TF){ // 첫 배열이 흰색이 아니면
                    cnt++; // 개수 증가
                }
                TF = (!TF); // 다음 기준은 반대를 기준으로 확인한다
            }
            TF = (!TF); // 층이 바뀌면 기준이 바뀐다.
        }
        // 기준이 검정색(반대)라고 가정하면 나오는 최소값
        return Math.min(cnt, 64-cnt);

    }

    private static int getMinSquare(int n, int m, boolean[][] chess) {

        int x = n - 7; // 행 탐색 횟수
        int y = m - 7; // 열 탐색 횟수
        int min = 64;

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                int cnt = find(i, j, chess); // 8x8 탐색을 통해 도출한 색변경 개수
                min = Math.min(cnt, min); // 최소값 갱신
            }
        }
        return min;

    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean[][] chess = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String str = sc.next();
            for(int j = 0; j < m; j++){
                if(str.charAt(j) == 'W'){ // 흰색이라면 참, 검정이라면 거짓
                    chess[i][j] = true;
                }
            }
        }

        int answer = getMinSquare(n, m, chess);
        System.out.println(answer);
    }
}
