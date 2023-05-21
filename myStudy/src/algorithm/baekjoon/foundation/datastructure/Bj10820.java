package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj10820 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();

        while (s != null){
            int cntLower = 0; // 소문자 개수
            int cntUpper = 0; // 대문자 개수
            int cntNum = 0; // 숫자 개수
            int cntBlank = 0; // 공백 개수

            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i); // 원소 쪼개기
                if(c == ' '){ // 공백이라면
                    cntBlank++;
                }else if(c >= '0' && c <= '9'){ // 숫자라면
                    cntNum++;
                }else if(c >= 'a' && c <= 'z') { // 소문자라면
                    cntLower++;
                }else{
                    cntUpper++;
                }
            }
            System.out.print(cntLower +" "+ cntUpper +" "+ cntNum +" "+ cntBlank);
            System.out.println();
            s = br.readLine();
        }


    }
}
