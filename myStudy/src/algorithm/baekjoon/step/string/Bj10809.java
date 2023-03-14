package algorithm.baekjoon.step.string;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Bj10809 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        String s = sc.next();
        int[] alphabet = new int[26];

        for(int i = 0; i < alphabet.length; i++){
            alphabet[i] = -1;
        }

        // baekjoon  2 = 0
        for(int i = s.length() - 1; i >= 0; i--){ // a = 97
            alphabet[s.charAt(i) - 97] = i;
        }
        for(int i : alphabet){
            System.out.print(i +" ");
        }

    }
}
