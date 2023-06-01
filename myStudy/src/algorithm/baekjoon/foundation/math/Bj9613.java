package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj9613 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int getGcd(int a, int b) {
        if(a % b == 0){
            return b;
        }
        return getGcd(b, a % b);
    }

    private static long getGcdSum() throws IOException{
        // 모든 GCD의 개수를 리턴
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 100만을 넘지 않는다.
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 100만을 넘지 않는다.
        }


        for(int i = 0; i < n; i++){
            for(int j = i + 1; j < n; j++){
                sum += getGcd(arr[i], arr[j]);
            }
        }
        return sum;
    }

    public static void main(String[] args) throws IOException {
        int caseSize = Integer.parseInt(br.readLine()); // 최대 100
        for(int caseIndex = 0; caseIndex < caseSize; caseIndex++){ // O(100 *
            long num = getGcdSum();
            System.out.println(num);
        }

    }
}
