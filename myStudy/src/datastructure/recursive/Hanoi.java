package datastructure.recursive;

import java.util.Scanner;

public class Hanoi {
    // 1. 바닥 원반을 제외한 그룹을 시작기둥에서 중간기둥으로 옮긴다
    // 2. 바닥의 원반을 시작기둥에서 목표기둥으로 옮긴다
    // 3. 중간기둥의 원판을 목표기둥으롱 ㅗㄹㅁ긴다
    private static void move(int n, int x, int y) { // x번 기둥의 n개를 y번 기둥으로 옮긴다
        if(n > 1)
            move(n - 1, x, 6 - x - y); // 기둥번호(1, 2, 3)의 합이 6이므로 중간기둥은 6 - x - y로 구할 수 있다
        System.out.printf("원반[%d]을 %d번 기둥에서 %d번 기둥으로 옮김 \n", n, x, y);

        if(n > 1)
            move(n - 1, 6 - x - y, y); //
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("원반의 개수 :");
        int n = sc.nextInt();

        move(n, 1, 3); // 1번 기둥의 n개를 3번기둥으로 옮긴다

    }
}
