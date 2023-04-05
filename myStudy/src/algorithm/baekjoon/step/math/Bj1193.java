package algorithm.baekjoon.step.math;

import java.util.Scanner;

public class Bj1193 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int x = sc.nextInt();
        // 분모와 분자의 합을 T라고 한다면 T가 짝수일 때 아래에서 오른쪽 방향으로, T가 홀수일 때 위에서 왼쪽 방향으로 이동
        int cross_count = 1; // 해당 범위의 대각선 칸의 개수
        int prev_count_sum = 0; // 해당 대각선 직전 대각선 까지의 칸의 누적합

        // x가 8이라면
        while (true){
            // 이전 대각선의 누적 + 현재 대각선의 개수를 이용해 범위를 판별한다
            if(x <= prev_count_sum + cross_count){
                if(cross_count % 2 == 0){
                    // 분자가 작은 수부터 시작
                    // 분모는 대각선 상 내의 블럭개수 - (x - 직전 대각선까지의 블럭개수 -1)
                    // 분자는 x - 직전 대각선까지의 블럭 개수
                    System.out.println((x - prev_count_sum) + "/" + (cross_count + 1 - (x - prev_count_sum)));
                    break;
                }
                else if (cross_count % 2 == 1){
                    // 분모가 큰 수부터 시작
                    System.out.println(cross_count - (x - prev_count_sum - 1) + "/" + (x - prev_count_sum));
                    break;
                }
            }else {
                prev_count_sum += cross_count; // 7
                cross_count++; // 4
            }
        }

    }
}
