package algorithm.baekjoon.step.intensification1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1157 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static char getFreqAlpha() throws IOException{
        // 가장 많이 사용된 알파벳을 대문자로 출력
        String s = br.readLine();
        int[] arr = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if (65 <= s.charAt(i) && s.charAt(i) <= 90) {  // 대문자일 때
                arr[s.charAt(i) - 65]++;
            }
            else{ // 소문자 일 때
                arr[s.charAt(i) - 97]++;
            }
        }

        int max = -1;
        char ch = '?';
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
                ch = (char) (i + 65); // 대문자로 출력
            } else if (arr[i] == max) {
                ch = '?';
            }
        }
        return ch;
    }

    public static void main(String[] args) throws IOException{
        char s = getFreqAlpha();
        System.out.println(s);
    }
}