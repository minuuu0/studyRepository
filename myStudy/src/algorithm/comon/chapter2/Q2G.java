package algorithm.comon.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 버블정렬 구현
public class Q2G {

    public static void bubbleSort(int[] data, int n){ // 5
        for(int i = 0; i < n; i++){
            int count = 0; // 오름차순인지 갯수를 통해 판별하여 성능 개선
            for(int j = 0; j+1 < n - i; j++){ // 첫 가지치기
                if(data[j] > data[j + 1]){
                    int temp = data[j];
                    data[j] = data[j+1];
                    data[j+1] = temp;
                    count++;
                }
            }
            if(count == 0){
                // data[0] ~ data[n-i-1]칸 까지 오름차순이다
                break;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 정렬 할 원소의 개수
        StringTokenizer st = new StringTokenizer(br.readLine()); // 정렬 할 원소 입력

        int[] data = new int[n]; // 배열 선언

        for(int i = 0; i < n; i++){
            data[i] = Integer.parseInt(st.nextToken());
        }
        bubbleSort(data, n);

        for(int a : data){
            System.out.println(a);
        }
    }
}
