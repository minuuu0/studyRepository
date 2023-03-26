package algorithm.baekjoon.step.factor;

import java.util.Scanner;

public class Bj2581 {
    // 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최솟값을 구하라
    // 소수가 없으면 -1 출력
    static final Scanner sc = new Scanner(System.in);



    public static void main(String[] args) {
        int m = sc.nextInt();
        int n = sc.nextInt();

        int sum = 0; // 소수들의 합
        int min = n; // 소수 중 최소값

        for(int i = m; i <= n; i++) { // m ~ n의 모든 범위의 값 소수 판별
            boolean prime = true; // 소수인지 판단
            if(i == 1) continue; // 1은 소수가 아니다
            if(i == 2) {
                sum += i;
                min = i;
                continue;
            }
            else if(i % 2 == 0) continue; // 짝수는 소수가 아님


            // 이미 위에서 i값이 짝수인 것을 배제했다
            // 그렇다면 짝수인 약수도 없을 것이다.
            for(int j = 3; j <= (int)Math.sqrt(i); j+=2){
                if(i % j == 0){ // 약수가 있다면
                    // 소수가 아니다
                    prime = false;
                    break;
                }
            }
            if(prime){
                sum += i;
            }
            if(min > i && prime){
                min = i;
            }
        }

        if(sum == 0){
            System.out.println(-1);
        }else{
            System.out.println(sum +"\n" + min);
        }
    }
}
