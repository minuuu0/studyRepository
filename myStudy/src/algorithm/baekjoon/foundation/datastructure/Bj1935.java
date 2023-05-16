package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj1935 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 피연산자 개수
        Double[] arr = new Double[n]; // 피연산자를 담을 배열
        Stack<Double> stack = new Stack<>();

        String s = br.readLine(); // 후위표현식 입력

        for(int i = 0; i < n; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c >= 'A' && c <= 'Z'){
                stack.push(arr[c - 'A']);
            }else{
                if(!stack.isEmpty()){ // 스택이 비지 않았다면
                    Double a = stack.pop(); // 위의 원소
                    Double b = stack.pop(); // 아래 원소

                    switch (c) {
                        case '+':
                            stack.push(b + a);
                            continue;
                        case '-':
                            stack.push(b - a);
                            continue;
                        case '*':
                            stack.push(b * a);
                            continue;
                        case '/':
                            stack.push(b/a);
                            continue;
                    }
                }
            }
        }

        System.out.printf("%.2f", stack.pop());
    }
}
