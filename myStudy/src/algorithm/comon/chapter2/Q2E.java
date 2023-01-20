package algorithm.comon.chapter2;

import java.util.Scanner;

public class Q2E {
    public static final Scanner sc = new Scanner(System.in);

    public static boolean isPrime(int n){
        // 소수에서 1, 2는 정해져있고 4이상 짝수들은 소수가 아니다
        if(n == 1) return false;
        if(n == 2) return true;
        if(n % 2 == 0) return false;

        // 위에서 1, 2는 판별을 했고 짝수들은 굳이 반복할 필요가 없다
        for(int i = 3; i <= Math.sqrt(n); i+=2){
            if(n % i == 0){
                return false;
            }
        }
        return true;

    }

    public static void testCase(int caseIndex){
        int n = sc.nextInt(); // 소수 판단할 데이터 입력
        boolean result = isPrime(n); // 결과 함수 호출

        System.out.printf("Case #%d\n", caseIndex);
        if(result){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        int caseSize = sc.nextInt(); // 테스트 케이스 개수를 입력
        for(int caseIndex = 1; caseIndex <= caseSize; caseIndex++){ // 입력한 데스트 케이스만큼 반복
            testCase(caseIndex); // testCase 함수 호출
        }
    }
}
