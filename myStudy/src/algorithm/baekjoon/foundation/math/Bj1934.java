package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1934 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int getGcd(int num1, int num2) {
        if(num2 == 0) return num1;

        int rem = num1 % num2;
        return getGcd(num2, rem);
    }

    private static void testCase() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());

        int gcd = getGcd(num1, num2);
        System.out.println(num1 * num2 / gcd);
    }

    public static void main(String[] args) throws IOException{
        int caseSize = Integer.parseInt(br.readLine());

        for(int caseIndex = 0; caseIndex < caseSize; caseIndex++){
            testCase();
        }
    }
}
