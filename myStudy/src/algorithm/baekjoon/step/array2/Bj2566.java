package algorithm.baekjoon.step.array2;

import java.util.Scanner;

public class Bj2566 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // 9 x 9 격자판의 81개의 자연수가 주어질 때 이 중 최대값을 찾고 몇행 몇열인지 구하라
        int[][] arr = new int[9][9];
        int max = 0; // 최대값 구하기
        int x = 0;
        int y = 0;

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                arr[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(arr[i][j] > max){
                    max = arr[i][j];
                    x = i + 1;
                    y = j + 1;
                }
            }
        }
        System.out.println(max);
        System.out.println(x +" " + y);

    }
}
