package algorithm.baekjoon.step.array2;

import java.util.Scanner;

public class Bj2738 {
    // n * m 크기의 두 행렬 A B가 주어질 때 두 행렬을 더하는 프로그램 작성
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt(); // 행
        int m = sc.nextInt(); // 열

        // 둘째 줄부터 n개의 줄에 행렬 A의 원소 m개가 차례대로 주어짐
        // 이어서 n개의 줄에 행렬 B의 원소 m개가 주어짐
        int[][] A = new int[n][m]; // [[], [], []] , [[], [], []] , [[], [], []]
        int[][] B = new int[n][m];

        // A 행렬 값 추가
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                A[i][j] = sc.nextInt();
            }
        }

        // B 행렬 값 추가
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                B[i][j] = sc.nextInt();
            }
        }

        // 두 행렬 덧셈
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < m; j++){
                System.out.print(A[i][j] + B[i][j] +" ");
            }
            System.out.println();
        }

    }
}
