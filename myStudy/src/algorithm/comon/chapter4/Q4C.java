package algorithm.comon.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q4C {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static long getGCD(int a, int b) { // 유클리드 호제법
        if(a % b == 0){
            return b; // 최대공약수 리턴
        }
        return getGCD(b, a % b);
    }


    private static void testCase(int caseIndex) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1 = Integer.parseInt(st.nextToken());
        int num2 = Integer.parseInt(st.nextToken());
        long gcd = getGCD(num1, num2);
        long lcm = (long)num1 * num2 / gcd; // 최소공배수 : num1 * num2 / 최대공약수

        System.out.printf("Case #%d:\n", caseIndex);
        System.out.printf("%d %d\n", gcd,lcm);
    }

    public static void main(String[] args) throws IOException {
        int t = Integer.parseInt(br.readLine());

        for(int caseIndex = 1; caseIndex <= t; caseIndex++){
            testCase(caseIndex);
        }

    }
}
