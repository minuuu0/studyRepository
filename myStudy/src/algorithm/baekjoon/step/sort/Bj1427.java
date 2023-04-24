package algorithm.baekjoon.step.sort;

import java.io.*;
import java.util.*;

public class Bj1427 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        // 2143
        // 큰 수는 맨 앞으로 옮긴다.

        String str = br.readLine();

        char[] charArray = str.toCharArray();

        for(int i = 1; i < str.length(); i++){ // key
            // 순회하며 기존의 정렬을 응용한다.
            for(int j = 0; j < i; j++){
                if(charArray[i] > charArray[j]){
                    char temp = charArray[i];
                    charArray[i] = charArray[j];
                    charArray[j] = temp;
                }
            }
        }
        String result = new String(charArray);
        System.out.println(result);
    }
}
