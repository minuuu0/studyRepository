package algorithm.comon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2B {
    // 값을 입력받아 오름차순이라면 YES, 아니라면 NO출력
    // 첫줄 입력 : 입력할 데이터 수(n)
    // 두번째 줄 입력 : 입력 데이터 arr
    public static boolean isOrdered(int[] arr, int n){
        int count = 0; // 인접쌍의 개수
        for(int i = 0; i+1 < n; i++){ // n = 5라면 0 ~ 3까지 반복
            if(arr[i] <= arr[i + 1]){
                count++;
            }else{
                break;
            }
        }
        // 총 (n - 1)개의 인접쌍이 오름차순이면 배열은 오름차순
        return  count == n - 1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n : 데이터 개수 입력
        StringTokenizer st = new StringTokenizer(br.readLine()); // 데이터 입력 : arr
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        boolean result = isOrdered(arr, n);
        if(result){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
