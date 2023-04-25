package algorithm.baekjoon.step.sort;

import java.util.*;
import java.io.*;
public class Bj11650 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine()); // 점의 개수

        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());

        }
        Arrays.sort(arr, (e1, e2) -> { // 람다 함수로 우선순위 부여
            if(e1[0] == e2[0]){
                return e1[1] - e2[1];  // 음수가 나오면 우선순위가 낮다
            }else{
                return e1[0] - e2[0];  // 양수가 나오면 우선순위가 높다
            }
        });

        for(int i = 0; i < n; i++) {
            System.out.println(arr[i][0] + " " + arr[i][1]);
        }
    }
}

