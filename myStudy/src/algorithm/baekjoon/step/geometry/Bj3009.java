package algorithm.baekjoon.step.geometry;

import java.util.Scanner;

public class Bj3009 {
    // 세 점이 주어졌을 때, 축에 평행한 직사각형 만들기 위해 필요한 네번째 점 찾는 문제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] x = new int[3];
        int[] y = new int[3];

        int ansX = 0;
        int ansY = 0;

        for(int i = 0; i < 3; i++){
            x[i] = sc.nextInt(); // x좌표
            y[i] = sc.nextInt(); // y좌표
        }

        if(x[0] == x[1]){
            ansX = x[2];
        } else if (x[0] == x[2]) {
            ansX = x[1];
        }else{
            ansX = x[0];
        }

        if(y[0] == y[1]){
            ansY = y[2];
        }else if (y[1] == y[2]){
            ansY = y[0];
        }else{
            ansY = y[1];
        }

        System.out.println(ansX +" " +ansY);
    }
}
