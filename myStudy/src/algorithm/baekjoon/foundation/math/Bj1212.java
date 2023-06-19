package algorithm.baekjoon.foundation.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bj1212 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String octat_num = br.readLine(); // 문자 입력


        int target = Character.getNumericValue(octat_num.charAt(0)); // 첫 문자를 꺼내
        String s = Integer.toBinaryString(target); // 2진수로 변환
        sb.append(s);

        for(int i=1; i<octat_num.length(); i++){
            target = Character.getNumericValue(octat_num.charAt(i)); // 첫 문자를 제외한 이후 문자
            s = Integer.toBinaryString(target); // 2진수로 변환
            if(s.length() == 3){
                sb.append(s);
            }
            else if(s.length()==2){
                sb.append("0" + s);
            }
            else if(s.length()==1){
                sb.append("00" + s);
            }
            else
                sb.append(s);
        }

        System.out.println(sb.toString());

    }
}