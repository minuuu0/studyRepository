package algorithm.baekjoon.step.array;

import java.util.HashSet;
import java.util.Scanner;

public class Bj3052 {
    static final Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        // 자연수 10개를 입력받아 이를 42로 나눈 나머지를 구하라 그 다음 서로 다른 나머지값이 몇 개 있는지

        HashSet<Integer> h = new HashSet<>();

        for(int i = 0; i < 10; i++){
            h.add(sc.nextInt() % 42);
        }
        System.out.println(h.size());

    }
}
