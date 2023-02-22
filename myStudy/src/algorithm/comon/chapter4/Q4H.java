package algorithm.comon.chapter4;

import java.util.Scanner;

public class Q4H {
    static final Scanner sc = new Scanner(System.in);
    private static void testCase(int caseIndex) {

        int m = sc.nextInt(); // 자연수 m  // 10, 12
        int n = sc.nextInt(); // 자연수 n

        int x = sc.nextInt(); // 자연수 k
        int y = sc.nextInt(); // 자연수 y 입력받은 x y가 몇번째 해인지 구해보쟈

        // 카잉 달력 생성
        KaingCalender calender = new KaingCalender(m, n);

        // 이 달력에서 <x, y>가 몇 번째 연도인지 계산
        int answer = calender.getIndex(x, y);

        System.out.println(answer);
    }

    public static void main(String[] args) {

        int caseSize = sc.nextInt();

        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }

    }
}
class KaingCalender{
    final int M; // 왼쪽 번호 최대 값
    final int N; // 오르쪽 번호 최대 값
    KaingCalender(int M, int N){
        this.M = M;
        this.N = N;
    }
    public int getXbyIndex(int index){
        return 1 + (index - 1) % M;
        // index % M = 나머지 0인 경우가 있기에 1을 뺏다가 결과값에 1을 더한다
    }
    public int getYbyIndex(int index){
        return 1 + (index - 1) % N;
    }

    // 이 달력에 <x, y>라는 연도가 최초로 등장하는 순번 (등장하지않으면 -1)
    public int getIndex(int x, int y){
        for(int index = x; index <= M * N; index+=M){ // x가 일치할 때만 탐색
            if(getYbyIndex(index) == y){ // x에 해당하는 index를 탐색하여 y와 일치한다면
                return index; // 해당 인덱스를 리턴한다.
            }
        }
        return -1;
    }

}
