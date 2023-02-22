package algorithm.comon.chapter4;

import java.util.Arrays;
import java.util.Scanner;

public class Q4I {
    static final Scanner sc = new Scanner(System.in);
    static final Sieve sieve = new Sieve(1000000);

    private static void testCase(int caseIndex) {
        int x = sc.nextInt(); // 자연수 x 입력

        int a = -1;
        int b = -1;

        for(int p = 3; p <= x / 2; p+=2){ // 홀수만 찾고, 작은값만 찾기위해 k/2
            int q = x - p;
            if(sieve.isPrime[q] == true && sieve.isPrime[p] == true){
                a = p;
                b = q;
                break;
            }
        }
        System.out.printf("Case #%d:\n", caseIndex);
        if(a > 0 && b > 0)
        {
            System.out.printf("%d = %d + %d\n", x, a, b);
        }else{
            System.out.println(-1);
        }
    }

    public static void main(String[] args) {
        int caseSize = sc.nextInt();
        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }
    }
}
class Sieve{
    public boolean[] isPrime;
    public int maxValue;

    Sieve(int maxValue){
        this.maxValue = maxValue;
        isPrime = new boolean[maxValue + 1];
        this.fillSieve();
    }

    public void fillSieve(){
        Arrays.fill(isPrime, true); // 에라토스테네스의 체
        // 모두 참으로 초기화하고 1은 소수아님 2의 배수를 탐색해 참이라면 거짓으로 바꾸기
        isPrime[1] = false;

        for(int i = 2; i <= maxValue; i++){
            if(isPrime[i] == false) continue;
            for(long mul = (long)i * i; mul <= maxValue; mul += i){ // 배수만큼 증가
                isPrime[(int)mul] = false;
            }
        }
    }

    public boolean isPrimeNumber(int num){
        return this.isPrime[num];
    }
}