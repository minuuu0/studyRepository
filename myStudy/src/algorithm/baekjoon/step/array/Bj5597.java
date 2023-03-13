package algorithm.baekjoon.step.array;

import java.util.Scanner;

public class Bj5597 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // x 대학 m교수는 수업을 맡는다. 학생은 30명이 있는데 그중28명이 제출했다. 제출안한 학생의 학생번호 출력
        // 입력은 총 28줄로 제출한 학생번호를 입력 // 1 ~ 30
        int[] stu = new int[30];

        for(int i = 0; i < 28; i++){
            stu[sc.nextInt() - 1]++;
        }
        for(int i = 0 ; i < 30; i++){
            if(stu[i] == 0)
                System.out.println(i + 1);
        }

    }
}
