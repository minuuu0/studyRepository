package algorithm.baekjoon.step.geometry;

import java.util.Arrays;
import java.util.Scanner;

public class Bj5073 {
    static final Scanner sc = new Scanner(System.in);
    // 세 변 길이에 따라 다음과 같이 정의
    // 1. 세 변의 길이가 모두 같은 경우
    // 2. 두 변의 길이만 같은 경우
    // 3. 세 변의 길이가 모드 다른 경우
    // 단 주어진 범위가 삼각형의 조건에 맞지 않으면 Invalid
    public static void main(String[] args) {
        while (true){
            int[] arr = new int[3];

            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();

            if(arr[0] == 0 && arr[1] == 0 && arr[2] ==0){
                break;
            }

            Arrays.sort(arr); // 정렬

            if(arr[0] + arr[1] <= arr[2]){ // 삼각형 가능 여부 판단
                System.out.println("Invalid");
            } else if (arr[0] == arr[1] && arr[1] ==arr[2] && arr[0] == arr[2]) { // 세변의 길이가 같으면
                System.out.println("Equilateral");
            } else if(arr[0] != arr[1] && arr[1] != arr[2] && arr[0] != arr[2]){
                System.out.println("Scalene");
            }else{
                System.out.println("Isosceles");
            }

        }
    }
}
