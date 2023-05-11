package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj17413 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        Stack<Character> st = new Stack<>(); // 스택 선언
        StringBuilder sb = new StringBuilder();

        boolean isTag = false;
        String s = br.readLine();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(c == '<'){
                isTag = true; // 태그가 있음을 알림
                // 이전까지의 문자열을 출력
                while (!st.isEmpty()){
                    sb.append(st.pop());
                }
                sb.append(c); // < 추가

            } else if (c == '>') {
                isTag = false;
                sb.append(c); 
            } else if (isTag) { // 태그가 잇다면
                sb.append(c);
            } else{ // 태그가 없다면
                if(c == ' '){ // 공백이라면 출력
                    while (!st.isEmpty()){
                        sb.append(st.pop());
                    }
                    sb.append(' ');
                }else{
                    st.push(c);
                }
            }
        }
        // 마지막 확인
        while( !st.isEmpty() ) {
            sb.append(st.pop());
        }
        System.out.println(sb);

    }
}
