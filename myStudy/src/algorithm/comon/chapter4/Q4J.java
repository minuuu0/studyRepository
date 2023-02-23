package algorithm.comon.chapter4;

import java.util.ArrayList;
import java.util.Scanner;

public class Q4J {
    static final Scanner sc = new Scanner(System.in);
    public static final int MAX_VALUE = 1000000;

    private static int getMaxiumGCD(int n, int[] cards) {
        int answer = 1;
        int[] frequency = new int[MAX_VALUE + 1];

        // 소인수분해를 한다.
        // 소인수에 대한 빈도수를 계산한다.
        for(int C: cards){
            ArrayList<Long> factors = MathUtil1.factorize(C);
            for(long f : factors){
                // 모든 소인수에 대해 빈도수 생성
                frequency[(int)f]++;
            }
        }
        // 각각의 소인수를 균등분할한다.
        for(int i = 2; i <= MAX_VALUE; i++){
            // 모든 소인수 i에 대해
            // 어차피 소인수 아니면 0이라 빈도수 스킵
             if(frequency[i] == 0) continue;

              // 균등분할 몇개씩?
            int count = frequency[i] / n;

            answer *= MathUtil1.powInt(i, count);
        }


        return answer;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        int[] cards = new int[n];

        for(int i = 0 ; i < n; i++){
            cards[i] = sc.nextInt();
        }

        int answer = getMaxiumGCD(n, cards);

        System.out.println(answer);
    }
}
class  MathUtil1{

    public static ArrayList<Long> factorize(long n) {
        ArrayList<Long> factors = new ArrayList<>();

        for(long div = 2; div * div <= n; div++){
            while (n % div == 0){
                // 소인수 목록에 div 추가
                factors.add(div);

                // N에서 소인수만큼 나눈다
                n /= div;
            }
        }
        if(n > 1){
            // 소인수를 찾지못하고 남아있는 n이라면 반드시 소수다 이를 소인수에 추가
            factors.add(n);
        }

        return factors;

    }

    // a ^ n을 구하는 함수
    public static int powInt(int a, int n){
        int result = 1;

        for(int i = 1; i <= n; i++){
            result *= a; // a를 n번 곱한다.
        }
        return result;
    }
}