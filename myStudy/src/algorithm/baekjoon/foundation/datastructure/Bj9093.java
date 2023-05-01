package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj9093 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        // 풀이 1 스택 이용
//        while (n-- > 0){ // 테스트 케이스에 대해
//            Stack<Character> stack = new Stack<>();
//            String str = br.readLine();
//
//            for(char ch : str.toCharArray()){ // string -> char 배열로 변환
//                if(ch == ' ' || ch == '\n'){ // 만약 띄어쓰기거나 줄바꿈일 경우
//                    while (!stack.isEmpty()){ // 스택이 비지 않을 때까지 반복
//                        System.out.println(stack.pop());
//                    }
//                }else{
//                    stack.push(ch);
//                }
//            }
//
//        }

        StringBuilder answer = new StringBuilder();  //최종 출력할 StringBuilder
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine()); // 단어마다 쪼개고
            while (st.hasMoreTokens()) {
                StringBuilder sb = new StringBuilder(st.nextToken());
                answer.append(sb.reverse() + " ");  //각 단어를 뒤집고 answer에 붙이기
            }
            answer.append("\n");
        }
        System.out.print(answer);
    }
}
