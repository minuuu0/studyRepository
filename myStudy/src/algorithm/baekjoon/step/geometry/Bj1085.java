package algorithm.baekjoon.step.geometry;

import java.util.Scanner;

public class Bj1085 {
    public static void main(String[] args) {
        // x, y에 있다 왼쪽 아래 꼭지점 : 0, 0 / 오른쪽 위 꼭지점 : w, h
        // 직사각형의 경계선까지 가는 최솟값 구하기

        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt(); // 현재 내 점의 x좌표
        int y = sc.nextInt(); // 현재 내 점의 y좌표
        int w = sc.nextInt(); // 오른쪽 위 꼭지점의 x좌표
        int h = sc.nextInt(); // 오른쪽 위 꼭지점의 y좌표

        int min = x; // 가장 거리가 가까운 변

        if(min > y) min = y;

        if(min > w - x) min = w - x;

        if(min > h - y) min = h - y;

        System.out.println(min);

    }
}
