package algorithm.baekjoon.step.factor;

import java.util.ArrayList;
import java.util.Scanner;

public class Bj11653 {
    static final Scanner sc = new Scanner(System.in);
    private static ArrayList<Integer> getPrimeFactor(int n) {
        ArrayList<Integer> list = new ArrayList<>();

        int i = 2;

        while (n > 1){
            if(n % i == 0){
                list.add(i);
                n /= i;
                i = 2;
            }
            else {
                i++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        int n = sc.nextInt();
        ArrayList<Integer> list = getPrimeFactor(n);
        for(int l : list){
            System.out.println(l);
        }

    }
}
