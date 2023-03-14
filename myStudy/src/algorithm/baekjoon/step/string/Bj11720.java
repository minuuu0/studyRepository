package algorithm.baekjoon.step.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bj11720 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        int n = sc.nextInt(); // 숫자 개수

        String num = sc.next();

        int sum = 0;
        for(int i = 0; i < num.length(); i++){
            sum += Integer.parseInt(num.substring(i, i+1));
        }
        System.out.println(sum);
    }
}
