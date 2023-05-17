package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10808 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int[] arr = new int[26];
        String s = br.readLine();

        for(int i = 0; i < s.length(); i++){
            arr[s.charAt(i) - 'a']++;
        }

        for(int a : arr){
            System.out.print(a +" ");
        }

    }
}
