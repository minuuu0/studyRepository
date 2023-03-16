package algorithm.baekjoon.step.intensification1;

import java.util.Scanner;

public class Bj2444 {
    static final Scanner sc = new Scanner(System.in);
    // 다이아 모양 별찍기
    public static void main(String[] args) {
        int n = sc.nextInt(); // 입력값의 다이아 생성

        for(int i = 0; i < n; i++){ // 윗부분
            for(int j = 0; j < n - i - 1; j++){
                System.out.print(" ");
            }
            for(int k = 0; k < i * 2 + 1; k++){
                System.out.print("*");
            }
            System.out.println();
        }

        for(int i = n - 1; i > 0; i--){
            for(int j = 0; j < n - i; j++){
                System.out.print(" ");
            }
            for (int k = 0; k < i * 2 - 1; k++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
