package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CountingSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // CountingSort
        // 개수를 탐색하여 정렬하는 방법 (비교 x) -> '범위조건'이 있는 경우에 한 굉장히 빠르다

        int n = Integer.parseInt(br.readLine()); // n = 입력 개수
        int[] arr = new int[n]; // 데이터가 들어가는 배열
        int[] cnt = new int[n]; // 숫자 세는 배열

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine()); // 배열에 값 초기화
        }

        for(int i = 0; i < n; i++){
            cnt[arr[i] - 1]++;
        }

        for(int i = 0; i < n; i++){
            if(cnt[i] != 0){ // 갯수가 0초과일때만 출력하는 조건
                int j = 0; // cnt를 몇번 출력할건지에 대한 변수 j
                while(j < cnt[i]){
                    System.out.println(i + 1);
                    j++;
                }
            }
        }

    }
}
