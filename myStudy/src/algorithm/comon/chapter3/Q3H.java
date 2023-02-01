package algorithm.comon.chapter3;

import java.util.Arrays;
import java.util.Scanner;

public class Q3H {
    static final Scanner sc = new Scanner(System.in);
    // 결과값 도출 함수
    private static int getPossibleTargetNumber(int n, int m, int[] cards, int[] target) {
        int answer = 0; // 만들 수 있는 당첨번호의 수

        Arrays.sort(cards); // O(N Log2 N)
        for(int k: target){ // +O(MN Log2 N)
            // k:= 모든 당첨번호가 들어온다
            // k가 cards[]의 합으로 표현될 수 있는지 확인
            boolean possible = false;
            for(int p : cards){
                int q = k - p;
                //cards 내에 q가 존재하는지만 검사 (이진탐색)
                if(Arrays.binarySearch(cards, q) >= 0){
                    // cards배열안에 q값이 있는지 검색 찾으면 인텍스값이 나오고 못찾으면 음수값이 나옴
                    possible = true;
                    break;
                }
            }
            if(possible){
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 사용할 카드의 수 n (1 ~ 10만)
        int m = sc.nextInt(); // 당첨 번호의 수 m (1~100)

        int[] cards = new int[n]; // n개의 카드의 수를 담을 배열
        int[] target = new int[m]; // 당첨 번호의 수를 담을 배열

        for(int i = 0; i < cards.length; i++){
            cards[i] = sc.nextInt(); // 카드 데이터 입력 (1 ~ 1억)
        }
        for(int i = 0; i < target.length; i++){
            target[i] = sc.nextInt(); // 당첨 번호 담을 배열 (1 ~ 2억)
        }
        // n개의 당첨번호 중 2개를 뽑아 2개를 합했을 때 당첨번호가 될 수 있는 값의 개수를 찾는 를제(중복된 카드를 뽑을 수 있다)
        // n = 5, m = 3이고
        // cards[1, 9, 2, 7, 3] , targets[6, 7, 8]이라면 1+7, 3+3(중복카드가능) 2개가 정답
        // ex) target 6을 찾는데 p라는 값에 2를 찾았다면 q는 4여야 target이랑 맞을것이다 즉 p + q = target
        // 즉 조합을 통해 이미 target과 p를 찾았다면 q의 값은 정해져있기 때문에 탐색으로 풀 수 있다 -> 효율적인 이진검색을 활용하자

        int answer = getPossibleTargetNumber(n ,m, cards, target);

        System.out.println(answer);


    }
}
