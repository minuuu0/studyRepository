package algorithm.baekjoon.step.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Bj25305 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt(); // 학생 수
        int k = sc.nextInt(); // 상 받는 학생 수
        int[] scores = new int[n];

        int index = 0;

        for(int i = 0; i < n; i++){
            scores[i] = sc.nextInt();
        }

        // 선택 정렬 구현
        // 선택 정렬 : 배열을 순회하며 최소값을 찾아 swap
        for(int i = 0; i < n - 1; i++){
            int min_index = i;
            // 최소값을 찾자
            for(int j = i + 1; j < n; j++){ // 최소값을 가지는 인덱스 찾기
                if(scores[j] < scores[min_index]){
                    min_index = j;
                }
            }

            int temp = scores[min_index];
            scores[min_index] = scores[i];
            scores[i] = temp;

        }

        System.out.println(scores[n - k]);
    }
}
