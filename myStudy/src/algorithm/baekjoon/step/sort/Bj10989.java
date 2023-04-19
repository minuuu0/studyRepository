package algorithm.baekjoon.step.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Bj10989 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        // 카운팅 정렬을 통해 해결
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[10001]; // 카운팅 배열

        for(int i = 0; i < n; i++){
            cnt[Integer.parseInt(br.readLine())]++;
        }

        br.close();

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < 10001; i++){
            // i값이 개수가 0이 될 때까지 출력(빈도수)
            while(cnt[i] > 0){
                sb.append(i).append('\n');
                cnt[i]--;
            }
        }
        System.out.println(sb);
    }
}
