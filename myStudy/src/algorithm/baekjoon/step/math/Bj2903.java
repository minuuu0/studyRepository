package algorithm.baekjoon.step.math;

import java.util.Scanner;

public class Bj2903 {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        long n = sc.nextInt();
        // 정사각형이기에 가로의 점의 개수를 제곱하면 총 점의 개수를 구할 수 있다
        // 가로의 점의 개수는 2 -> 3 -> 5 -> 9 -> 17 -> 33
        // 즉 이전의 점의 개수 * 2 - 1

        int point = 2; // 초기 가로 점의 개수

        for(int i = 0 ; i < n; i++){
            point = point * 2 - 1;
        }
        System.out.println(point * point);


    }
}
