package algorithm.syu.midterm;

import java.util.Scanner;

public class Chap3 {
    static final Scanner sc = new Scanner(System.in);
    private static void hanoi(int a, int b, int c, int n) { // 시작, 중간, 목표, n개의 원판
        if(n == 1){
            System.out.println(a +" " + c);
            return;
        }
        hanoi(a, c, b, n-1); // n -1개의 원판을 기둥2로 이동
        System.out.println(a + " " + c);
        hanoi(b, a, c,n - 1); // n - 1개의 원판을 기둥3으로 이동
    }

    private static double pow(double x, int n) {
        if(n == 0) {
            return 1;
        }
        String s

        if(n % 2 == 0){
            return pow(x * x, n / 2);
        }else{
            return pow(x * x, n / 2) * x;
        }

    }

    public static void main(String[] args) {
        double x = sc.nextDouble();
        int n = sc.nextInt();

        // 분할 정복
        double ans = pow(x, n);
        System.out.println(ans);

        // 하노이탑 풀어보기
        hanoi(1, 2, 3, 3); // 원판 3개를 1번기둥에서 3번기둥으로 옮기자


    }
}
