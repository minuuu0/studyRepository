package algorithm.baekjoon.step.array;

import java.util.Scanner;

public class Bj10807 {
    public static final Scanner sc = new Scanner(System.in);
    private static int getNum(int[] arr, int v) {
        int cnt = 0;
        for (int i = 0 ; i < arr.length; i++){
            if (arr[i] == v) cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int n = sc.nextInt(); // 정수의 개수 N

        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int v = sc.nextInt(); // 찾을 v값

        int answer = getNum(arr, v);
        System.out.println(answer);

    }
}
