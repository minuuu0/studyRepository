package algorithm.baekjoon.step.intensification1;

import java.util.Scanner;

public class Bj3003 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // 검정 피스는 다 잇는데 흰색피스가 부족
        // 총 16개 피스 킹1개, 퀸1개, 룩2개, 비숍2개, 나이트2개, 폰 8개
        // 동혁이가 발견한 흰색 피스의 개수가 주여졌을 때 몇개를 더하거나 빼야 올바른 세트가 되는지

        // 킹, 퀸, 룩, 비숍, 나이트, 폰의 개수(0 ~ 10)
        int king = sc.nextInt();
        int queen = sc.nextInt();
        int rook = sc.nextInt();
        int bishop = sc.nextInt();
        int knight = sc.nextInt();
        int pawn = sc.nextInt();

        System.out.print(1 - king + " ");
        System.out.print(1 - queen + " ");
        System.out.print(2 - rook + " ");
        System.out.print(2 - bishop + " ");
        System.out.print(2 - knight + " ");
        System.out.print(8 - pawn);

    }
}
