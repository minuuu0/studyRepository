package algorithm.baekjoon.step.geometry;

import java.util.Scanner;

public class Bj14215 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int[] arr = new int[3];
        int max = 0; // 최대값 인덱스 저장

        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
            if(arr[i] > arr[max]){ // 최대값 배열 인덱스를 계속 찾아낸다
                max = i;
            }
        }

        // max := 최대값이 있는 인덱스 나머지의 특성을 이용하면 배열의 인덱스를 몰라도 찾을 수 있다.

        if(arr[max] < arr[(max + 1) % 3] + arr[(max + 2) % 3]){ // 위 조건에선 삼각형이 된다
            System.out.println(arr[max] + arr[(max + 1) % 3] + arr[(max + 2) % 3]);
        }else{
            System.out.println(arr[(max + 1) % 3] + arr[(max + 2) % 3] - 1 + arr[(max + 1) % 3] + arr[(max + 2) % 3]);
        }


    }
}
