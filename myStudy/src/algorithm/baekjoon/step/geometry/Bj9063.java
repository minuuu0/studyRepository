package algorithm.baekjoon.step.geometry;

import java.util.Scanner;

public class Bj9063 {
    static final Scanner sc = new Scanner(System.in);
    private static int getGroundArea(int n) {
        int area = 0; // 땅의 넓이
        if(n == 1) return 0; // 옥의 개수가 1개라면 넓이는 0

        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;

        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int x = sc.nextInt(); //
            int y = sc.nextInt();

            maxX = Math.max(maxX, x); // x값의 최대를 구한다
            minX = Math.min(minX, x); // x값의 최소를 구한다

            maxY = Math.max(maxY, y); // y값 최대
            minY = Math.min(minY, y); // y값 최소
        }
        area = (maxX - minX) * (maxY - minY);
        return area;

    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 옥구슬 위치 n개

        int answer = getGroundArea(n);
        System.out.println(answer);
    }
}
