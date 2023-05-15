package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Bj17299 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine()); // 수열의 크기
        StringTokenizer st = new StringTokenizer(br.readLine()); // 입력 값 쪼개기
        int[] arr = new int[n];
        int[] arrCount = new int[1000001]; // 빈도수 체크 테이블
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num; // 배열 원소 할당
            arrCount[num]++; // 빈도 수 증가
        }

        for(int i = 0 ; i < n; i++){ // 인덱스 탐색

            while (!stack.isEmpty() && arrCount[arr[i]] > arrCount[arr[stack.peek()]]){ // 스택이 빌 때까지
                arr[stack.pop()] = arr[i];
            }
            stack.push(i); // 스택에 인덱스 추가
        }

        while(!stack.isEmpty()) { // 위 과정을 거치고 스택에 남아있는 인덱스는 오큰수가 없는 것.
            arr[stack.pop()] = -1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            sb.append(arr[i]).append(' ');
        }
        System.out.println(sb);

    }
}
