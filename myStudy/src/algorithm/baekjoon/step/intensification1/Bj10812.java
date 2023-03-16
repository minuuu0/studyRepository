package algorithm.baekjoon.step.intensification1;

import java.util.Scanner;

public class Bj10812 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt();  // 바구니 개수 n
        int m = sc.nextInt(); // 바구니 순서 바꾸기 개수

        int[] baskets = new int[n];
        int[] newBaskets = new int[n];
        for(int i = 0; i < n; i++){
            baskets[i] = i + 1; // 바구니 값 초기화
            newBaskets[i] = i + 1; // 비교 바구니 초기화
        }

        for(int l = 0; l < m; l++){
            // 1based 배열 이기에 입력값에서 -1
            int i = sc.nextInt() - 1; // begin 3
            int j = sc.nextInt() - 1; // end 9
            int k = sc.nextInt() - 1; // mid 8
            int ii = i; // i값 저장 변수

            // 1 2 3 4 5 6 7 8 9 10
            // 1 6 4라면 배열의 4 5 6 1 2 3 7 8 9 10
            // 3 9 8 -> 4 5 8 9 6 1 2 3 7 10
            for(int g = 0; g < j - i + 1; g++){ // 순서 회전 수만큼 반복
                if(k + g <= j){
                    // mid ~ end까지
                    newBaskets[g + i] = baskets[k + g];
                }else{
                    // begin ~ mid -1까지
                    newBaskets[g + i] = baskets[ii];
                    ii++;
                }
            }

            for(int g = 0; g < n; g++){
                baskets[g] = newBaskets[g]; // 바구니 초기화
            }
        }
        for(int b : newBaskets){
            System.out.print(b + " ");
        }
    }
}
