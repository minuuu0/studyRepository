package algorithm.baekjoon.class2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj1085 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken()); // 찾을 점의 x 좌표
        int y = Integer.parseInt(st.nextToken()); // 찾아야할 점의 y좌표
        int w = Integer.parseInt(st.nextToken()); // 직사각형의 너비 w
        int h = Integer.parseInt(st.nextToken()); // 직사각형의 높이 h

        int[] arr = new int[4];
        // 높이에서 y를 빼고
        arr[0] = h - y;
        arr[1] = y - 0;
        // 너비에서 x를 뺀다
        arr[2] = w - x;
        arr[3] = x - 0;

        int min = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] < min){
                min = arr[i];
            }
        }
        System.out.println(min);
    }
}
