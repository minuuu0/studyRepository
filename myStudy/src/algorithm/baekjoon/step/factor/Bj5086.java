package algorithm.baekjoon.step.factor;

import java.util.Scanner;

public class Bj5086 {
    // 4 x 3 = 12 -> 12는 3의 배수, 4의배수
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // 두 수가 주어졌을 때 첫 수가 두 수의 약수인지, 배수인지, 둘다 아닌지 판별
        while (true){
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a == 0 && b == 0){
                break;
            }

            // 약수라면
            if(b % a == 0){
                System.out.println("factor");
            }
            else if (a % b == 0){
                System.out.println("multiple");
            }else {
                System.out.println("neither");
            }

        }

    }
}
