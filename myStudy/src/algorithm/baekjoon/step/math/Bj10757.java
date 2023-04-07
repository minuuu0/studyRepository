package algorithm.baekjoon.step.math;

import java.math.BigInteger;
import java.util.Scanner;

public class Bj10757 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BigInteger bg = new BigInteger(sc.next());
        BigInteger bg1 = new BigInteger(sc.next());

        System.out.println(bg.add(bg1));
    }
}
