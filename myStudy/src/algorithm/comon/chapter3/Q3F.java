package algorithm.comon.chapter3;

import java.util.Scanner;

public class Q3F {
    public static final Scanner sc = new Scanner(System.in);
    private static Range getBestRange(int n, int m, int[] cards, Range[] range) {
        Range answer = range[0]; // 정답 초기화

        // 누적합 배열 생성
        long[] rangeSum = new long[n + 1]; // 인덱스 0은 제외한다
        rangeSum[0] = 0; // 자바는 생략해도 되지만 가독성을 위해
        // 누적합 배열을 활용한 구간합 순회
        for(int i = 1; i <= n; i++){
            // rangeSum을 채우자
            rangeSum[i] = rangeSum[i - 1] + cards[i];
        }


        for(Range r : range){ // 모든 객체에 대해서
            // r.totalpoint = cards[r.left] ~ card[r.right]의 구간합
            r.totalPoint = rangeSum[r.right] - rangeSum[r.left - 1]; //left 이전까지의 합을 뺀다
            if(answer.totalPoint < r.totalPoint){
                answer = r;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 숫자카드 개수 입력
        int m = sc.nextInt(); // 숫자카드를 선택한 사람 수

        Range[] range = new Range[m]; // 사람이 선택한 정보를 담을 객체배열

        int[] cards = new int[n+1];  // 인덱스값을 1로 맞추기 위해 공간을 하나 더 할당
        for(int i = 1; i <= n; i++){
            cards[i] = sc.nextInt(); // 32비트 정수값을 입력
        }

        for(int i = 0; i < m; i++){
            int left = sc.nextInt(); // 선택한 L값 입력
            int right = sc.nextInt(); // R값 입력
            range[i] = new Range(i + 1, left, right);
            // 결과를 도출하기 위해서 몇번째로 선택한지 알아야하기에 인덱스번호를 객체에 저장한다
        }

        // 범위의 합이 가장 큰 범위를 계산
        Range answer = getBestRange(n, m, cards, range);
        System.out.printf("%d %d\n", answer.index, answer.totalPoint);

    }
}
// 회원이 입력한 값을 가지고 있는 클래스
class Range{
    int index;
    int left;
    int right;
    long totalPoint; // 32비트 정수값이 오바될 수 있으니 Long

    Range(int index, int left, int right){
        this.index = index;
        this.left = left;
        this.right = right;
        this.totalPoint = 0;
    }

}