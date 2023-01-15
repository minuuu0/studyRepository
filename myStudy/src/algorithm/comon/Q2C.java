package algorithm.comon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2C {
    public static void main(String[] args) throws IOException {
        // 번호의 종류 개수 구하기 ex) 1 1 2 3 4 -> 4가지  / 1 2 3 4 5 -> 5가지
        // 첫 줄에는 입력 수(n)를,
        // 두번째 줄에는 번호를 입력한다, 단 입력은 오름차순으로 주어진다
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // n 값을 입력받는다

        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[n]; // n개의 배열

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 배열에 값 추가
        }

        // 종류 갯수를 구하는 방법의 알고리즘으론 두 단계가 있다
        // 1) 첫 값은 반드시 첫번째 종류의 값이 나온다
        // 2) 두 값을 비교하여 서로 다른값이라면 다른 종류의 값이 나온다
        int cnt = 0; // 번호 종류의 수를 카운트하는 변수
        for(int i = 0; i < n; i++){
            if(i == 0 || arr[i] != arr[i-1]){
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
