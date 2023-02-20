package algorithm.comon.chapter4;

import java.util.ArrayList;
import java.util.Scanner;

public class Q4E {
    public static Scanner sc = new Scanner(System.in);
    private static void testCase(int caseIndex) {
        long N = sc.nextInt(); // 소인수 분해 할 자연수

        ArrayList<Long> factors = MathU.factorize(N);

        System.out.printf("#%d:\n", caseIndex);

        for(long fac : factors){
            System.out.print(fac + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int caseSize = sc.nextInt(); // 테스트케이스 수 입력

        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }
    }
}
class MathU{

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
}
