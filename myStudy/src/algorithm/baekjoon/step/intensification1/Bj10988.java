package algorithm.baekjoon.step.intensification1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Bj10988 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    private static int isPalindrome() throws IOException {
        String s = br.readLine();
        sb.append(s);

        br.close();
        if(sb.toString().equals(sb.reverse().toString())){
            return 1;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) throws IOException{
        int answer = isPalindrome();
        System.out.println(answer);
    }
}
