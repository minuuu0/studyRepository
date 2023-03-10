package algorithm.baekjoon.step.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10871 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 정수 n개로 이루어진 수열
        int x = Integer.parseInt(st.nextToken()); // 정수 X


        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < n; i++){
            int value = Integer.parseInt(st.nextToken());
            if(value < x){
                sb.append(value).append(' ');
            }
        }
        System.out.println(sb);

    }
}
