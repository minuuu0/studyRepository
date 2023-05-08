package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj1158{
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> que = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken()); // 인원 수 N
        int k = Integer.parseInt(st.nextToken()); // k번 째 사람 제거

        for(int i = 1; i <= n; i++){
            que.add(i); // 원소 삽입
        }
        sb.append("<");

        // 본격 알고리즘 k번째 원소를 제거한다 -> k 이전의 원소들을 poll하여 add한다 (앞의 원소 뒤로 이동)
        while (!que.isEmpty()){ // 원소가 다 사라질 때 까지 반복

            for(int i = 0; i < k - 1; i++){
                que.add(que.poll()); // k - 1 번째까지는 add
            }
            int num = que.poll();

            if(!que.isEmpty()){ // 큐가 비지 않으면
                sb.append(num+", ");
            }
            else{
                sb.append(num);
            }

        }
        sb.append(">");

        System.out.println(sb);
    }
}
