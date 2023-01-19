package algorithm.comon.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2I {
    private static boolean inConsecutive(int[] data, int n) {
        // 정렬을 통해 풀지 않고 중복되지 않는 연속 순열의 케이스에 대해 O(N) 시간복잡도를 가진 알고리즘으로 풀어보자
        int Max = data[0];
        int Min = data[0];

        for(int i = 0; i < n; i++){
            if(Max < data[i]){
                Max = data[i];
            }
            // else if를 하지 않는 이유는 최대값 최소값을 안쓰는 값으로 초기화 할 수 있고 원소가 1개라면 둘다 최소최대가 되기 때문
            if(Min > data[i]){
                Min = data[i];
            }
        }
        return Max - Min + 1 == n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 데이터의 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine()); // 데이터 입력

        int[] data = new int[n]; // 데이터의 수 만큼 배열 할당
        for(int i = 0 ; i < data.length; i++){
            data[i] = Integer.parseInt(st.nextToken()); // 배열에 데이터 삽입
        }

        boolean result = inConsecutive(data, n); // 연속 순열 판별 함수

        if(result){ // 결과에 따른 출력 구분
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
