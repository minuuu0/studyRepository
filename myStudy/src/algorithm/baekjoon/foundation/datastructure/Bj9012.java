package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj9012{
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static boolean getPs() throws IOException{

        Stack<Character> st = new Stack<>();

        String s = br.readLine(); // (()()() 입력

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);

            if(c == '('){ // 원소가 ( 인 경우
                st.push(c);
            }
            else{ // 원소가 ) 인 경우
                if(st.isEmpty()){ // 스택이 이미 비어있다면
                    return false;
                }
                st.pop();
            }
        }

        if(st.isEmpty()){ // 스택이 빈다면 옳다
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for(int j = 0 ; j < n ; j++){ // 테스트케이스마다
            boolean ans = getPs();
            if(ans){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }

    }
}
