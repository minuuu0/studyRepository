package algorithm.comon.chapter3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q3J {
    static final Scanner sc = new Scanner(System.in);

    private static ArrayList<Integer> getPossibleTargets(int n, int m, int[] cards, int[] target) {

        // 두개의 카드끼리 짝을 지어 페어의 리스트를 만들고 두개의 페어를 고르는 식으로 문제 변환
        ArrayList<Integer> possibleTargets = new ArrayList<>(); // 만들 수 있는 당첨번호들

        ArrayList<CardPair> pairs = new ArrayList<CardPair>(); // 페어리스트

        for(int p: cards){
            for(int q:cards){
                pairs.add(new CardPair(p, q));
            }
        }
        // pairs : n^2가지 두 장의 카드 조합 페어들이 저장되어 있다
        Collections.sort(pairs); // 이진검색을 위한 정렬

        for(int k : target){
            boolean possible = false;
            // k = (p + q) + (r + s) 가 되는 숫자가 있는지 검사
            for(CardPair pair : pairs){ // 페어를 하나 골라
                int r_plus_s = k - pair.sumOfCards;
                CardPair targetPair = new CardPair(r_plus_s);
                if(Collections.binarySearch(pairs, targetPair) >= 0){ // targetPair가 pairs 와 같은 값이 있다면
                    possible = true;
                    break;
                }
            }
            if(possible){ // 하나 이상의 정답이 발견됐다면 = k는 네 숫자의 합으로 만들 수 있다
                possibleTargets.add(k);
            }
        }
        return possibleTargets;
    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 카드의 수
        int m = sc.nextInt(); // 당첨 번호의 수

        int[] cards = new int[n];
        int[] targets = new int[m];

        for(int i = 0; i < n; i++){
            cards[i] = sc.nextInt(); // 카드 데이터 입력
        }
        for(int i = 0; i < m; i++){
            targets[i] = sc.nextInt(); // 당첨 데이터 입력
        }

        ArrayList<Integer> answers = getPossibleTargets(n, m, cards, targets);

        if(answers.size() == 0)
        { // 가능한 당첨번호가 없다면 NO를 출력한다
            System.out.print("NO");
        }else
        { //가능한 당첨번호가 존재한다면 그 목록을 출력한다.
            for(int i = 0 ; i < answers.size() ; i++)
            {
                if( i > 0 )
                {
                    System.out.print(" ");
                }
                System.out.print(answers.get(i));
            }
        }

    }
}
// Comparable 인터페이스 : 객체간의 정렬, 비교, 탐색
class CardPair implements Comparable<CardPair> {
    int card1;
    int card2;
    int sumOfCards; // 두 카드의 합

    // 두개의 카드 정보를 알 때
    CardPair(int card1, int card2){
        this.card1 = card1;
        this.card2 = card2;
        this.sumOfCards = this.card1 + this.card2;
    }

    // 두 카드의 정보는 모르고 합은 알 때
    CardPair(int sumOfCards){
        this.sumOfCards = sumOfCards;
        this.card2 = -1;
        this.card1 = -1;
    }

    // 두 숫자의 합을 기준으로 정렬, 탐색
    @Override
    public int compareTo(CardPair o) {
        return this.sumOfCards - o.sumOfCards;
    }
}
