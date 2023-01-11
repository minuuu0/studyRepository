package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SellectionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine()); // n = 정렬 데이터 갯수(배열의 크기)
        int arr[] = new int[n]; // 배열 크기 할당

        for(int i = 0; i < n; i++){ // 배열에 값 추가하기 (정렬 데이터)
            arr[i] = Integer.parseInt(br.readLine());
        }
        for(int j = 0; j < n; j++) { // 최솟값 위치 변경
            int minIndex = j; // 가장 작은 인덱스
            for (int i = 0; i < n - 1; i++) { // 첫번째 인덱스부터 n번째 인덱스까지 최소값 비교
                if (arr[minIndex] < arr[i]) {
                    minIndex = i;
                }
                int temp = arr[j];
                arr[j] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        for(int a : arr){
            System.out.println(a);
        }
    }
}
