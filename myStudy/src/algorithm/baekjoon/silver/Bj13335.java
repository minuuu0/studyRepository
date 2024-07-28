package algorithm.baekjoon.silver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bj13335 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리의 길이
        int l = Integer.parseInt(st.nextToken()); // 다리의 하중

        st = new StringTokenizer(br.readLine());
        Queue<Integer> trucks = new LinkedList<>();
        Queue<Integer> bridge = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            trucks.offer(Integer.parseInt(st.nextToken())); // 트럭 큐에 값 추가
        }
        for (int i= 0; i < w; i++) {
            bridge.offer(0); // 가데이터
        }

        int cnt = 0;
        int currentWeight = 0; // 지금 하중
        while (!bridge.isEmpty()) {
            currentWeight -= bridge.poll();
            cnt++;
            if (!trucks.isEmpty()) {
                currentWeight += trucks.peek();
                if (currentWeight > l) {
                    currentWeight -= trucks.peek();
                    bridge.add(0);
                } else {
                    // 추가 되지 않아도 최대하중을 넘음
                    int goB = trucks.poll();
                    bridge.add(goB);
                }
            }
        }

        System.out.println(cnt);

    }

}
