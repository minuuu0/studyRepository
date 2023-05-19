package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10809 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String str = br.readLine();
        int[] arr = new int[26];

        for(int i = 0; i < arr.length; i++){
            arr[i] = -1; // -1로 초기화
        }

        // 알파벳이 단어 포함되는 경우 위치를, 포함되지 않다면 -1로 작성

        for(int i = str.length() - 1; i >= 0; i--){ // a = 1, b = 2
            arr[str.charAt(i) - 'a'] = i; // baekjoon
        }
        for(int a : arr){
            System.out.print(a +" ");
        }
    }
}
