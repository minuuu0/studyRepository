package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj17013 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static boolean[] prime = new boolean[1000001]; // true면 지워진 것
    private static void getPrime() {
        prime[0] = prime[1] = true;
        for(int i = 2; i <= Math.sqrt(1000001); i++){ // O(100만)
            // 자신을 제외한 배수 지우기
            if(prime[i] == true){ // 해당 원소가 지워졋다면 스킵
                continue;
            }

            for(long j = (long)i * i; j < 1000001; j += i){
                prime[(int)j] = true;
            }
        }

    }

    private static void testCase() throws IOException{
        int n = Integer.parseInt(br.readLine());

        // tc가 100이니 O(N)은 무리가 있다
        int ans = 0; //
        for (int j = 2; j <= n / 2; j++) { // N (최대 100만) / 2 까지 순회한다 -> 소수라 있다면 이에 대응되는 소수가 있기 때문
            if (!prime[j] && !prime[n - j]) ans++;
        }
        System.out.println(ans);
    }

    public static void main(String[] args) throws IOException {
        getPrime();
        int caseSize = Integer.parseInt(br.readLine());

        for(int caseIndex = 0; caseIndex < caseSize; caseIndex++){ // worst case 100
            testCase();
        }

    }
}
