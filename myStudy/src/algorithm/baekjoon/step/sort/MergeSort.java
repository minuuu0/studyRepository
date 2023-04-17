package algorithm.baekjoon.step.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MergeSort {
    private static void mergeSort(int[] arr) {
        int[] temp = new int[arr.length]; // 배열의 임시 저장 장소
        mergeSort(arr, temp, 0, arr.length - 1); // 정렬할 배열, 임시저장소, 시작과 끝 인덱스를 넘긴다

    }

    private static void mergeSort(int[] arr, int[] temp, int start, int end) {

        if(start < end){ // 시작 인덱스가 끝 인덱스보다 작은 경우만
            int mid = (start + end) / 2; // 배열을 반으로 쪼갠다
            mergeSort(arr, temp, start, mid);  // 배열을 반으로 분리
            mergeSort(arr, temp, mid + 1, end);// 재귀가 완료된 후에는 쪼갠 배열들이 정렬이 완성된 상태
            merge(arr, temp, start, mid, end); // 두개의 배열방을 병합하자
        }

    }

    private static void merge(int[] arr, int[] temp, int start, int mid, int end) {
        for(int i = start; i <= end; i++){
            temp[i] = arr[i]; // 임시 저장소에 배열 복사
        }
        int part1 = start; // 첫번째 배열의 첫원소
        int part2 = mid + 1; // 두번째 배열의 첫원소
        int index = start; // 양쪽 배열방에서 비교 후 결과 배열방의 삽입할 인덱스

        while (part1 <= mid && part2 <= end){ // 두개의 배열 중 한개의 원소가 남을 때까지
            if(temp[part1] <= temp[part2]){
                arr[index] = temp[part1];
                part1++;
            }else{
                arr[index] = temp[part2];
                part2++;
            }
            index++;
        }

        // 뒤쪽 배열은 비고 앞쪽 배열은 남은 경우
        for(int i = 0; i <= mid - part1; i++){ // 중간 - 앞쪽 포인터
            arr[index + i] = temp[part1 + i];
        }
        // 뒤쪽 배열에 데이터가 남을 경우는 최종 배열의 뒤쪽에 자리하고 있기에 신경 안써도 된다.
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        // 병합 정렬 구현하기
        mergeSort(arr);
        for(int a : arr){
            System.out.println(a);
        }

    }

}
