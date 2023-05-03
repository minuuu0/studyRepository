package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Bj1874 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(); // 출력 결과물 저장
        int start = 0; // 비교할 시작 변수

        while (n-- > 0){ // n번 반복

            int value = Integer.parseInt(br.readLine());

            if(value > start){ // 스택에 해당 값이 없는 경우
                for(int i = start + 1;  i <= value; i++){
                    st.push(i);
                    sb.append("+\n");
                }
                start = value;
            }
            // 최상단 원소가 입력받은 값과 같지 않은 경우에는 수열을 만족할 수 없다.
            else if (st.peek() != value) {
                System.out.println("NO");
                return;
            }
            st.pop();
            sb.append("-\n");

        }
        System.out.println(sb);

    }
}
