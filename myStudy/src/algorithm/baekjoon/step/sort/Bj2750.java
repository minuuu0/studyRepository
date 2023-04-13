package algorithm.baekjoon.step.sort;

import java.util.Scanner;

public class Bj2750 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // 삽입 정렬로 풀어보자
        int n = sc.nextInt(); // 수의 개수
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        // 5 8 6 2 4
        for(int i = 1; i < n; i++){ // 1 ~ n까지 비교
            for(int j = 0; j < i; j++){ // 하나를 선택(i)해 맨 앞부터 자신까지 비교하며 자신의 위치를 찾는다.
                if(arr[j] > arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for(int i = 0; i < n; i++){
            System.out.println(arr[i]);
        }
    }
}
