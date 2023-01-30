package algorithm.comon.chapter3;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Q3D {
    public static final Scanner sc = new Scanner(System.in);
    public static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 정적 데이터 캐싱
    public static final int MAX_N = 1000000 + 1;
    public static int[] FIBONACCI_TABLE;

    public static int[] makeFibonacciTable(int n){
        int[]fib = new int[n + 1];
        fib[0] = 0;
        fib[1] = 1;
        // 배열을 통해 피보나치 구하기
        for(int i = 2; i <= n; i++){
            fib[i] = (fib[i - 1] + fib[i - 2]) % 100000000;
        }
        return fib;
    }

    // 정적 데이터 캐싱을 이용해 값 도출
    public static int getFibo(int n){
        int answer = FIBONACCI_TABLE[n];
        return answer;
    }

    public static void main(String[] args) throws IOException {
        //가능한 모든 범위에 대한 피보나치 수열의 값을 계산해두자
        FIBONACCI_TABLE = makeFibonacciTable(MAX_N); // O(MAX_N) => 100만번 수행 O(N)

        // 테스트케이스 생성
        int caseSize = sc.nextInt();
        for(int i = 0; i < caseSize; i++){   // O(caseSize) + O(N)의 시간복잡도를 결국 가지게 됨
            int n = sc.nextInt();

            int answer = getFibo(n);
            bw.write(String.valueOf(answer) + "\n");
        }
        //불필요한 배열은 가능하면 할당 해제해주는 버릇을 들이자.
        FIBONACCI_TABLE = null;

        bw.flush();
        bw.close();
    }
}
