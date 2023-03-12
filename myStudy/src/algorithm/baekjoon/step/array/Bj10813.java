package algorithm.baekjoon.step.array;

import java.util.Scanner;

public class Bj10813 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt(); // 바구니의 수
        int m = sc.nextInt(); // 바꿀 공의 횟수

        // 바구니에는 공이 1개씩 들어있고 공을 m번 바꾸려고 한다 바구니의 번호는 1~n
        // 바구니 2개를 선택해 서로 교환하는 프로그램

        int[] arr = new int[n];
        for (int i = 0; i < n; i++){
            arr[i] = i + 1; // 바구니 번호 할당
        }
        for(int k = 0; k < m; k++){
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }

        for(int i : arr){
            System.out.print(i +" ");
        }

    }
}
