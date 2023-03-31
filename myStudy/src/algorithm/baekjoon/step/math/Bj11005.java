package algorithm.baekjoon.step.math;

import java.util.Scanner;
import java.util.Stack;

public class Bj11005 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 10진수 n을
        int b = sc.nextInt(); // b진수로 출력한다

        Stack<Integer> st = new Stack<>();

        while (n > 0){
            st.add(n % b);
            n /= b;
        }

        while (!st.isEmpty()){
            int num = st.pop();
            if(num > 10){ // 만약 스택값이 10이상이면 알파벳으로 출력
                System.out.print((char)(num - 10 + 'A'));
            }else{
                System.out.print(num);
            }
        }

    }
}
