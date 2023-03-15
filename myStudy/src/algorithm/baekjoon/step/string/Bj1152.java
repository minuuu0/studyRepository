package algorithm.baekjoon.step.string;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Bj1152 {
    static final Scanner sc = new Scanner(System.in);

    // The Curious Case of Benjamin Button
    public static void main(String[] args) {
        String s = sc.nextLine();

        StringTokenizer st = new StringTokenizer(s);

        System.out.println(st.countTokens());
    }
}
