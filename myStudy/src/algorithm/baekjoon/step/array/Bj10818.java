package algorithm.baekjoon.step.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10818 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int value = Integer.parseInt(st.nextToken());
            if(value < min){
                min = value;
            }else if(value > max){
                max = value;
            }
        }

        System.out.println(min +" " + max);
    }
}
