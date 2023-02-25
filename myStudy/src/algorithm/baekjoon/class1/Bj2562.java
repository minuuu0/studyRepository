package algorithm.baekjoon.class1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj2562 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static void findMax(int[] arr) {

        int max = arr[0];
        int index = 1;

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                index = i + 1;
            }
        }
        System.out.println(max);
        System.out.println(index);
    }

    public static void main(String[] args) throws IOException {

        int[] arr = new int[9];

        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        findMax(arr);

    }
}
