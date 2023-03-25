package algorithm.baekjoon.step.factor;

import java.util.Scanner;

public class Bj9506 {
    private static void getPerfectNum(int n) {

        StringBuilder sb = new StringBuilder();
        int sum = 1;

        sb.append(n+" = 1");

        for(int i = 2; i <= n; i++){ // 1은 반드시 약수이니 2부터 탐색
            if(n == i) break; // 자기를 제외함

            if(n % i == 0){
                sum += i;
                sb.append(" + " + i);
            }
        }

        if(sum == n){
            System.out.println(sb);
        }else{
            System.out.println(n +" is NOT perfect.");
        }
    }

    public static void main(String[] args) {
        // 완전수 : 자신을 제외한 모든 약수들의 합이 같다 -> 참인지 확인
        Scanner sc = new Scanner(System.in);

        while (true){
            int n = sc.nextInt(); // 완전수인지 판단할 n
            if(n == -1) break;

            getPerfectNum(n);

        }

    }
}
