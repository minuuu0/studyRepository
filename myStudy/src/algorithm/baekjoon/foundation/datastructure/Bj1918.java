package algorithm.baekjoon.foundation.datastructure;

import java.io.*;
import java.util.*;
import java.util.Stack;

public class Bj1918 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            char c = str.charAt(i); // 문자열 쪼개기
            if(Character.isLetter(c)){ // 피연산자라면
                sb.append(String.valueOf(c));
            }
            else if (c == '('){ // 연산자의 경우
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '('){ // (문자는 후위표현식에서 적용하지 않음
                    sb.append(stack.pop()); // 연산자 값 추가
                }
                stack.pop(); // '(' 제거
            }else{ // () 처리가 끝난 경우
                // 기존에 연산자가 스택에 있는 경우에 우선순위 비교
                while (!stack.isEmpty() && getPriority(c) <= getPriority(stack.peek())){ // 앞의 연산자가 우선순위가 높은경우
                    sb.append(stack.pop()); // d
                }
                stack.push(c);
            }
        }
    }

    private static int getPriority(char c) {
        if (c == '*' || c == '/')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return 0;
    }
    }
}
