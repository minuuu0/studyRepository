package algorithm.baekjoon.step.factor;

import java.util.Scanner;

public class Bj1978 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); // 입력할 수의 개수
        int answer = 0; // 소수의 개수

        for(int j = 0; j < a; j++){
            int n = sc.nextInt();
            if(n == 1) {
                continue;
            }
            if(n == 2){
                answer++;
                continue;
            } else if (n % 2 == 0) { // 2를 제외한 짝수는 소수가 아니다
                continue;
            }

            int cnt = 0; // 약수의 개수

            for(int i = 3; i <= (int)Math.sqrt(n); i+=2){ // 3까지는 소수다
                if(i == 1) continue;
                if(n % i == 0){
                    cnt++;
                    break; // 약수가 하나라도 있으면 바로 종료
                }
            }
            if(cnt == 0){
                answer++;
            }
        }
        System.out.printf("%d", answer);
    }
}
