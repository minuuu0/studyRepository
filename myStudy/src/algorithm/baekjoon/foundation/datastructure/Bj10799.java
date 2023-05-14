package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj10799 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        String s = br.readLine();
        Stack<Character> st = new Stack<>();

        int result = 0;
        for(int i = 0; i < s.length(); i++){
            char charS = s.charAt(i);
            if(charS == '('){
                st.push('('); // 열린괄호면 push
                continue;
            }
            if(charS == ')'){
                st.pop(); // 일단 스택에서 pop 실행
                if(s.charAt(i - 1) == '('){
                    result += st.size(); // 현재 스택의 사이즈 만큼 더해줌
                }else{ // 레이저가 아니면
                    result++; // 1을 더한다
                }
            }
        }
        System.out.println(result);
    }
}
