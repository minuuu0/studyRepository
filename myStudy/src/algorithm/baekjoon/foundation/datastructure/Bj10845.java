package algorithm.baekjoon.foundation.datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj10845 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int num = 0; // 큐의 마지막 원소 (마지막 push값)

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String s = st.nextToken();

            if(s.equals("push")){
                num = Integer.parseInt(st.nextToken());
                q.add(num);
            } else if (s.equals("front")) {
                if(q.isEmpty()){ // 큐에 원소가 없다면 -1 출력
                    sb.append(-1);
                }else{
                    sb.append(q.peek()).append("\n");
                }
            }else if (s.equals("back")){
                if(q.isEmpty()){ // 큐에 원소가 없다면 -1 출력
                    sb.append(-1).append("\n");
                }else{
                    sb.append(num).append("\n");
                }
            }else if (s.equals("size")){
                sb.append(q.size()).append("\n");
            } else if (s.equals("empty")) {
                if(q.isEmpty()){ // 큐가 비어있다면 1
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else{ // pop
                if(q.isEmpty()){ // 큐가 비어있다면 -1출력
                    sb.append(-1).append("\n");
                }else{
                    sb.append(q.poll()).append("\n");
                }
            }

        }
        System.out.println(sb.toString());
    }
}
