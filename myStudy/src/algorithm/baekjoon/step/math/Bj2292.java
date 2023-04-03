package algorithm.baekjoon.step.math;

import java.util.Scanner;

public class Bj2292 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt(); // n번방까지 갈 때 몇개의 방을 지나가는지
        int room = 1; // 지나가는 방 회수 카운트
        int range = 2;

        if(n == 1) System.out.println(1);

        else{
            while (range <= n){
                range = range + (6 * room);
                room++;
            }
            System.out.println(room);
        }

    }
}
