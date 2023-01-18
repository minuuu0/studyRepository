package algorithm.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bj4153 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[3]; // 배열 할당

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());// 값 입력받아서
            arr[0] = Integer.parseInt(st.nextToken()); // 배열에 값 추가
            arr[1] = Integer.parseInt(st.nextToken());
            arr[2] = Integer.parseInt(st.nextToken());
            Arrays.sort(arr); // 정렬을 통해 피타고라스 법칙 적용하기

            if (arr[0] ==0){
                break; // 첫값이 0
            }


            if (arr[0]*arr[0]+arr[1]*arr[1] == arr[2]*arr[2]){ // 피타고라스 법칙에 따른 답 구분
                System.out.println("right");
            }else{
                System.out.println("wrong");
            }
        }
    }
}

