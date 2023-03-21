package algorithm.syu.reculsive;

import java.util.Scanner;

public class PrintDigit {
    static final Scanner sc = new Scanner(System.in);
    private static void rPrintDigits(int n) {

        if(n != 0){
            rPrintDigits(n / 10); // 10씩 쪼개어 첫자리수부터 출력
            System.out.println(n % 10);
        }
    }

    public static void main(String[] args) {
        int n =sc.nextInt();

        rPrintDigits(n); // 함수 호출

    }
}
