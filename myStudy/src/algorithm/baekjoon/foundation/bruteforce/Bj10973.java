package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10973 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    private static boolean nextPermutation(int[] arr) {
        int i = arr.length - 1;
        while (i > 0 && arr[i - 1] < arr[i]){
            i--;
        }

        if(i == 0){
            return false;
        }

        int j = arr.length - 1;
        // swap 수 찾기
        while (arr[i - 1] < arr[j]){
            j--;
        }

        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = arr.length - 1;
        while (i < j) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation(arr)) {
            for (int i : arr) {
                System.out.print(i + " ");
            }

        }else{
            System.out.println(-1);
        }
    }

}
