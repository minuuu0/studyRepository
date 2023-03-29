package algorithm.baekjoon.step.geometry;

import java.util.Scanner;

public class Bj10101 {
    static final Scanner sc = new Scanner(System.in);
    // 삼각형 구분 프로그램 작성
    public static void main(String[] args) {
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        if(a + b + c != 180){ // 무조건 세 합이 180이 되게된다
            System.out.println("Error");
        } else if(a == b && b == c){ // 어차피 무조건 세 합이 180이니 세 값이 같다면 맞게된다
            System.out.println("Equilateral");
        } else if (a == b || b == c || a == c) {
            System.out.println("Isosceles");
        }else {
            System.out.println("Scalene");
        }
    }
}
