package algorithm.baekjoon.step.intensification1;

import java.util.Scanner;

public class Bj4344 {
    static final Scanner sc = new Scanner(System.in);
    private static void testCase() {
        int n = sc.nextInt(); // 학생의 수
        int[] scores = new int[n]; // 학생 점수
        int sum = 0;
        int cnt = 0; // 평균 넘는 학생

        for(int i = 0; i < n; i++){
            scores[i] = sc.nextInt();
            sum += scores[i];
        }
        float avg = sum / n;

        for(int i = 0; i < n; i++){
            if(scores[i] > avg){
                cnt++;
            }
        }
        double answer = (double)cnt / n;
        System.out.printf("%.3f%%\n", answer * 100);
    }

    public static void main(String[] args) {
        int caseSize = sc.nextInt();

        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase();
        }
    }
}
