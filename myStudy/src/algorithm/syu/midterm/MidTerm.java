package algorithm.syu;

import java.util.Scanner;

public class MidTerm {

    static final Scanner sc = new Scanner(System.in);

    // 4월 20일 알고리즘 중간고사 큰 수 찾기 알고리즘
    private static void getBigNum() {
        int[] arr = {1, 3, 2, 5, 4, 6};
        int max = 0;

        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        System.out.println(max);

        System.out.println("배열의 최대값은 " + max);
    }

    // 4. 20일 팩토리얼 구하기
    private static int getFactorial(int n) { // 5 * 4 * 3 * 2 * 1
        if(n == 1){
            return 1;
        }
        return n * getFactorial(n - 1);
    }

    public static void main(String[] args) {
        // 1장 큰수 찾기 알고리즘 (4월 20일)
        getBigNum();
        int fac = getFactorial(5);
        System.out.println(fac);
    }
}
