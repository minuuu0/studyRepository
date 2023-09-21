package algorithm.baekjoon.foundation.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bj10972 {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // 다음 순열 여부 판단 함수
    private static boolean nextPermutation(int[] arr) {
        int n = arr.length; // n := 배열의 크기

        // 뒤에서 오름차순이 깨지는 시점찾기(내림차순 깨지는 시점)
        int i = n - 1;
        while (i > 0 && arr[i - 1] >= arr[i]){
            i--;
        }

        // 이미 가장 큰 순열이면 다음 순열이 없음 , := 수열이 모두 내림차순일 때
        if(i <= 0){
            return false;
        }

        // i - 1 위치와 교환할 다음으로 큰 수 찾기
        int j = n - 1;
        while (arr[j] <= arr[i - 1]){
            j--;
        }

        // swap
        int temp = arr[i - 1];
        arr[i - 1] = arr[j];
        arr[j] = temp;

        j = n-1; // 다시 배열의 크기로 초기화
        while (i < j){
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return true;

    }

    public static void main(String[] args) throws IOException{
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 다음 순열을 찾는 함수
        if(nextPermutation(arr)){
            for (int i : arr) {
                System.out.print(i + " ");
            }
        }else{
            System.out.println(-1);
        }

    }
}
