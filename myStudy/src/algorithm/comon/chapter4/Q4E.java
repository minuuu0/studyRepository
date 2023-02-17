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

        long i = 2;
        while(n > 1){
            if(n % i == 0){
                n /= i;
                factors.add(i);
            }else{
                i++;
            }
        }

        return factors;

    }
}
