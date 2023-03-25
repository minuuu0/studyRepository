package algorithm.baekjoon.step.factor;

import java.util.Scanner;

public class Bj2501 {
    private static int getDivisor(int n, int k) {
        int cnt = 0;
        int ans = 0;
        for(int i = 1; i <= n; i++){
            if(n % i == 0){
                // 약수라면
                cnt++;
                if(cnt == k){
                    ans = i;
                    return ans;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        // 두 자연수 n, k가 주어질 때 n의 약수 k번째를 구하여라
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int answer = getDivisor(n, k);
        System.out.println(answer);
    }
}
