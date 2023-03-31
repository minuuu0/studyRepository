package algorithm.baekjoon.step.math;


import java.util.Scanner;

public class Bj2745 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.next(); // 문자열
        int b = sc.nextInt(); // 진법 b
        int ans = 0; // 정답

        // Z : 35

        // 36진법 ZZZ = Z * (36 ^ 2) + z * (36 ^ 1) + z * (36 ^ 0)
        // str.charat으로 쪼개면 아스키코드 값이 나온다
        // 정수와 문자의 구분을 위해 조건을 걸어준다.

        for(int i = 0; i < str.length(); i++){ // 각 문자를 쪼개어 진법변환
            // 아스키코드 0 ~ 9 => 48 ~ 57
            int z = 0;
            if('0' <= str.charAt(i) && '9' >= str.charAt(i)){ // 정수값이라면
                // str.charAt(i) - '0' = 원래 정수로 변환
                z = str.charAt(i) - '0';
            }else { // 문자값이라면
                z = str.charAt(i) - 'A' + 10;
            }
            ans += z * Math.pow(b, str.length() - 1  - i);
        }
        System.out.println(ans);

    }
}
