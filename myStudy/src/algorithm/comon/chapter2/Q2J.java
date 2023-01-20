package algorithm.comon.chapter2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q2J {
    private static boolean isWinnable(int[] data, int n, int k) { // n : 4 k : 2
        int winCount = 0;
        long sum = 0;

        // 첫 윈도우는 이전 값을 참조하지 못하니 따로 처리해준다
        for(int i = 0; i < k; i++){
            sum += data[i];
        }
        if(sum % 2 == 0){
            return true;
        }

        for(int i = 1; i + k - 1 < n; i++) { // 첫 윈도우를 제외한 나머지 윈도우
            sum = sum - data[i -1] + data[i + k - 1]; // 기존의 합에서 이전윈도우의 첫 값을 빼고 기존 윈도우의 마지막값을 추가하면 된다

            if (sum % 2 == 0){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // n = 입력 데이터 수
        int k = Integer.parseInt(st.nextToken()); // k = k개의 범위를 묶어 순회
        int[] data = new int[n]; // n개의 배열 할당

        st = new StringTokenizer(br.readLine()); // 실제 데이터 입력
        for(int i = 0; i < n; i++){
            data[i] = Integer.parseInt(st.nextToken()); // 배열에 데이터 추가
        }

        boolean result = isWinnable(data, n, k);

        if(result){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
