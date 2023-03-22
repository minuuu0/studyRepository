package algorithm.syu.reculsive;

import java.util.Scanner;

public class Hanoi {
    static final Scanner sc = new Scanner(System.in);
    private static void getHanoi(int n, int from, int to, int temp) {
        // n개의 원판이 있다면 n - 1개의 원판을 2번기둥에 옮기고 n개의 기둥원판을 3번기둥으로 옮긴다
        // a b를 출력하는데 a번째 탑의 가장 위의 원판을 b로 옮긴다.
        // n - 1개의 원판을 원하는 곳에 옮길수만 있다면 n개의 원판을 처리할 수 있다 -> 재귀함수

        // 2 ^ n - 1의 이동 횟수를 가짐

        // 1. 함수의 정의 getHanoi(n)이 아닌 출발 기둥, 도착 기둥, 목표 기둥에 대한 함수 정의 필요 getHanoi(n, a, b, tmp) -> 원판 n개를 a번 기둥에서 b번 기둥으로
        // 2. baseCondition n = 1일 때(원판 1개일 때) a에서 b로 이동
        // 3. 재귀 식 : a도 b도 아닌 기둥은 6 - a - b(1번기둥, 2번기둥, 3번기둥)이다
        // 재귀식 - 1 : n - 1개의 원판을 기둥 a에서 보조기둥으로 옮긴다
        // 재귀식 - 2 : n번 원판을 목표기둥으로 옮긴다
        // 재귀식 - 3 : n - 1개의 원판을 보조기둥에서 목표기둥으로 옮긴다

        if(n == 1){
            System.out.println(from +" " + to);
            return;
        }
        getHanoi(n - 1, from, temp, to); // n-1개의 원판을 시작기둥에서 보조기둥으로 이동한다
        System.out.printf("%d %d\n", from, to);
        getHanoi(n - 1, temp, to, from); // n-1개의 원판을 보조기둥에서 목표기둥으로 이동


    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 원판의 개수
        getHanoi(n, 1, 3, 2);
        sc.close();
    }
}
