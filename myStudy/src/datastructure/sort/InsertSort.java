package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InsertSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n = 정렬할 데이터 수 = 9
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine()); // 배열에 데이터 넣기 7 3 2 8 9 4 6 1 5
        }

        for(int i = 1; i < n; i++){
            int target = arr[i]; // target = 타겟 번호

            int j = i - 1; // j = 타겟과 비교하는 인덱스번호

            while(j >= 0 && target < arr[j]){ // 배열의 첫요소까지 && 타겟이 비교대상보다 작으면
                arr[j + 1] = arr[j]; // 자리 swap
                j--; // 반복을 위한 조건
            }
            arr[j + 1] = target; // 자리 swap
        }

        for(int a : arr){
            System.out.println(a);
        }
    }
}
