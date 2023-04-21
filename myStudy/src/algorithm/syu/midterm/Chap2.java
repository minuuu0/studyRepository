package algorithm.syu.midterm;

import java.util.Arrays;

public class Chap2 {
    private static int getBinarySearch(int[] arr, int start, int end, int value) {
        int mid = (start + end) / 2;
        if (arr[mid] == value) { // value와 원소가 같다면
            return mid; // 해당 원소 인덱스 리턴
        } else if (arr[mid] > value) {
            return getBinarySearch(arr, start, mid - 1, value);
        } else {
            return getBinarySearch(arr, mid + 1, end, value);
        }
    }



    public static void main(String[] args) {
        int[] arr = {45, 20, 60, 35, 10, 55, 90, 85, 75, 25};

        int val = 85;
        // 1. 순차 탐색 구현

        for(int i = 0; i < arr.length; i++){
            if(val == arr[i]){
                val = i;
            }
        }
        System.out.println("순차탐색 인덱스 : " + val);


        // 2. 이진탐색 구현 (정렬을 요구한다)
        Arrays.sort(arr);
        int result = getBinarySearch(arr, 0, arr.length -1, 90);
        System.out.println("이진탐색 인덱스 : " + result);

        // 3. 동전 알고리즘(그리디 알고리즘)
        val = 730;
        int cnt = 0; // 동전의 개수 변수
        cnt = val / 500;
        val %= 500;

        cnt += val / 100;
        val %= 100;

        cnt += val / 50;
        val %= 50;
        cnt += val/ 10;
        System.out.println("동전의 수 : " + cnt);

    }
}
