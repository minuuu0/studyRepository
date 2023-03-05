package algorithm.baekjoon.class2;

import java.util.Scanner;

public class Bj2798 {
    static final Scanner sc = new Scanner(System.in);
    private static int getBlackJack(int n, int m, int[] cards) {

        int maxSum = 0; // m과 가장 가까운 최대값

        // 3개를 고르기 때문에 첫 카드는 n-2까지
        for(int i = 0; i < n - 2; i++){
            // 두번째 카드는 첫번째 카드 다음부터 n-1까지만 순회
            for (int j = i + 1; j < n-1; j++){
                // 셋번째 카드는 두번째 카드 다음부터 n까지
                for(int k = j + 1; k < n; k++){

                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= m && sum > maxSum){
                        maxSum = sum;
                    }
                }
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 카드의 개수 n
        int m = sc.nextInt(); // 카드의 합과 최대한 가깝게 만드는 숫자 m

        int[] cards = new int[n]; // n개의 카드 배열 생성
        for(int i = 0; i < n; i++){
            cards[i] = sc.nextInt();
        }

        int answer = getBlackJack(n, m, cards);
        System.out.println(answer);
    }
}
