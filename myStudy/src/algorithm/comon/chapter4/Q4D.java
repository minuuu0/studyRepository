package algorithm.comon.chapter4;

import java.util.Scanner;

public class Q4D {
    static Scanner sc = new Scanner(System.in);
    private static long getGlobalPeriod(int n, long[] sizes) {
        return MathUtil.getLCM(sizes);
    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 수열의 개수
        long[] sizes = new long[n]; // 수열 주기

        for(int i = 0 ; i < n; i++){
            sizes[i] = sc.nextInt();
        }

        long answer = 1 + getGlobalPeriod(n, sizes);

        System.out.println(answer);
    }
}
class MathUtil{
    public static long getLCM(long[] numbers){
        if(numbers.length == 0){ // 들어오는 배열의 수가 없다면 0리턴(예외처리)
            return 0;
        }
        long lcm = numbers[0]; // 최소공배수를 구해 미리 계산한다
        for(int i = 1; i < numbers.length; i++){
            // lcm := numbers[0] ~ numbers[i - 1]에 대한 최소공배수
            lcm = getLCM(lcm, numbers[i]);
            // lcm := numbers[0] ~ numbers[i]에 대한 최소공배수
        }
        return lcm;
    }
    public static long getLCM(long a, long b){
        return a * b / getGCD(a, b);
    }
    public static long getGCD(long a, long b){
        if(a % b == 0){
            return b;
        }
        return getGCD(b, a % b);
    }
}
