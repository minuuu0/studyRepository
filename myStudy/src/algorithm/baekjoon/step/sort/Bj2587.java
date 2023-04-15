package algorithm.baekjoon.step.sort;

import java.util.Arrays;
import java.util.Scanner;

public class Bj2587 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int[] arr = new int[5];
        int sum = 0;

        for(int i = 0; i < 5; i++){
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        // 버블 정렬 직접 구현하기
        for(int i = 0; i < 4; i++){ // 버블 정렬은 n -1 번 순회하면 된다
            for(int j = 0; j + 1 < 5 - i; j++){ // 순회하는 마지막 원소는 최대값을 갖기에 순회할필요 없다
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // 중앙 값 출력
        System.out.println(sum / 5);
        System.out.println(arr[2]);

    }
}
