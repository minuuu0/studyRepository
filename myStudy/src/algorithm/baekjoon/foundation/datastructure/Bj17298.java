package algorithm.baekjoon.foundation.datastructure;

import java.util.*;
import java.io.*;
import java.util.Stack;

public class Bj17298 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine()); // 원소 값 입력
        int[] seq = new int[n]; // 배열 할당
        Stack<Integer> stack = new Stack<>(); // 인덱스 보관

        for (int i = 0; i < n; i++){
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0 ; i < n; i++){
            // 스택이 비지않고, 스택의 최상단 원소가 seq[i]가 작을 때
            while (!stack.isEmpty() && seq[stack.peek()] < seq[i]){
                seq[stack.pop()] = seq[i]; // 해당 인덱스의 오큰수를 찾았다.
            }
            stack.push(i); // 해당 인덱스 스택에 추가
        }
        while(!stack.isEmpty()) { // 위 과정을 거치고 스택에 남아있는 인덱스는 오큰수가 없는 것.
            seq[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(seq[i]).append(' ');
        }
        System.out.println(sb);
    }
}
