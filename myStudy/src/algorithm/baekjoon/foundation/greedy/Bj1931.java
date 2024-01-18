package algorithm.baekjoon.foundation.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj1931 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[][] time = new int[n][2];
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            time[i][0] = Integer.parseInt(st.nextToken()); // 시작 시간
            time[i][1] = Integer.parseInt(st.nextToken()); // 종료 시간
        }

        Arrays.sort(time , (o1, o2) -> {
            if (o1[1] == o2[1]) { // 만약 종료시간이 서로 같으면 시작 시간으로 정렬
                return o1[0] - o2[0];
            }
            return o1[1] - o2[1]; // 종료 시간이 같지 않으면 종료 시간으로 정렬
        });


        int prev_end = 0; // 이전 종료 시간을 저장
        for (int i = 0; i < n; i++) {
            if (prev_end <= time[i][0]) {
                prev_end = time[i][1];
                cnt++;
            }
        }

        System.out.println(cnt);


    }

}
