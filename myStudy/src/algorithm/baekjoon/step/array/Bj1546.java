package algorithm.baekjoon.step.array;

import java.util.Scanner;

public class Bj1546 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt(); // 시험 본 과목의 수 n (1000이하)
        int[] scores = new int[n];

        for(int i = 0; i < n; i++){
            scores[i] = sc.nextInt(); // 세준이의 성적
        }

        int max = scores[0];
        double sum = 0;
        for(int i = 0; i < n; i++){
            if(scores[i] > max){
                max = scores[i];
            }
            sum += scores[i];
        }


        System.out.println((sum / max * 100) / n);
    }
}
