package algorithm.comon.chapter4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// 소수 세기 알고리즘
public class Q4F {
    static final Scanner sc = new Scanner(System.in);
    static final Sieve sieve = new Sieve(1000000);

    private static ArrayList<Integer> getAllPrimeNumbers(int l, int r) {
        // l ~ r의 소수를 구하자 ex) 2, 5 -> 2, 3, 5

        ArrayList<Integer> primes = new ArrayList<>();

        for(int num = l; num <= r; num++){
            if(sieve.isPrimeNumber(num) == true){
                primes.add(num);
            }
        }
        return primes;
    }

    private static void testCase(int caseIndex) {
        int l = sc.nextInt(); // 자연수 L (L은 항상 R이하)
        int r = sc.nextInt(); // 자연수 R

        ArrayList<Integer> allPrimeNumbers = getAllPrimeNumbers(l, r);

        System.out.printf("Case #%d:", caseIndex);
        System.out.println(allPrimeNumbers.size()); // arrayList의 크기를 가져와 개수 파악

    }

    public static void main(String[] args) {
        // 주어진 범위에 존재하는 소수의 수를 출력하는 프로그램 작성
        int caseSize = sc.nextInt();
        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){
            testCase(caseIndex);
        }
    }
}

class Sieve { // 소인수분해를 빠르게
    final int maximumValue; // 에라토스테네스의 체에서 다룰 가장 큰 범위의 값
    final boolean[] isPrime; // 각 숫자별 소수 여부
    Sieve(int maximumValue){
        this.maximumValue = maximumValue;
        this.isPrime = new boolean[maximumValue+1];
        this.fillSieve();
    }
    public boolean isPrimeNumber(int num){
        return this.isPrime[num];
    }

    // isPrime 배열값 채우는 함수
    private void fillSieve() {
        Arrays.fill(isPrime, true); // 모두 true로 초기화

        // 반복문으로 모든 자연수를 오름차순으로 조회하고
        // 만약 소수가 아니라면 스킵하고 소수라면 배수를 false처리
        for(int i = 2; i <= maximumValue; i++){
            if (isPrime[i] == false){
                // 이미 앞에서 어떤 소인수가 이 수를 배수로서 삭제했다
                continue;
            }
            // num은 소수다
            for(long mul = (long)i * i; mul <= maximumValue; mul+=i){ // 이미 2부터 i - 1까지의 배수는 이미 삭제했으니 스킵
                isPrime[(int)mul] = false;
            }
        }
    }

}