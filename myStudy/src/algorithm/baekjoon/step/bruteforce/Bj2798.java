package algorithm.baekjoon.step.bruteforce;

import java.util.Scanner;

public class Bj2798 {
    static final Scanner sc = new Scanner(System.in);
    private static int getCards(int n, int m, int[] cards) {
        int max = 0;

        for(int i = 0; i < n - 2; i++){
            if (cards[i] > m) continue;
            for(int j = i + 1; j < n - 1; j++){
                if (cards[i] + cards[j] > m) continue;
                for(int k = j + 1; k < n; k++){
                    int sum = cards[i] + cards[j] + cards[k];
                    if(sum == m){
                        return sum;
                    }
                    if(sum > m){
                        continue;
                    }
                    max = sum > max ? sum : max;
                }
            }
        }
        return max;

    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 카드의 개수 n
        int m = sc.nextInt(); // 카드의 총합 m

        int[] cards = new int[n];

        for(int i = 0; i < n; i++){
            cards[i] = sc.nextInt(); // 카드의 값 입력
        }

        int answer = getCards(n, m, cards);
        System.out.println(answer);
    }
}
