package algorithm.baekjoon.step.array;

import java.util.Scanner;

public class Bj10811 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // n개의 바구니를 가지고 있고 1 ~ n의 번호 m번 바구니를 역순으로 가장 왼쪽 바구니부터 모두 출력
        // 역순 방법은 i j를 입력해 i~j까지의 바구니 순서를 역순
        int n = sc.nextInt(); // 바구니의 개수 n
        int m = sc.nextInt(); // 바구니 역순 수

        int[] baskets = new int[n];

        for(int i = 0; i < n; i++){
            baskets[i] = i+1;
        }
        for(int k = 0; k < m; k++){
            int i = sc.nextInt() - 1;
            int j = sc.nextInt() - 1;

            while (i < j){
                int temp = baskets[i];
                baskets[i] = baskets[j];
                baskets[j] = temp;
                j--;
                i++;
            }
        }
        for(int b : baskets){
            System.out.print(b+" ");
        }

    }
}
