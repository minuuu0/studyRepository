package algorithm.baekjoon.step.math;

import java.util.Scanner;

public class Bj2869 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int a = sc.nextInt(); // 달팽이가 낮동안 올라간 거리
        int b = sc.nextInt(); // 달팽이가 밤동안 떨어진 거리
        int v = sc.nextInt(); // 나무 높이 (최대 10억)

        // 2 1 5
        // 5 1 6
        int result = (v - b) / (a - b); // 올라간 날짜 =  높이 - 떨어진거리 / 올라간거리 - 떨어진거리
        if((v - b) % (a - b) != 0){ // 만약 나눠떨어지지 않다면 하루가 더 가야한다
            result++;
        }
        System.out.println(result);
    }
}
