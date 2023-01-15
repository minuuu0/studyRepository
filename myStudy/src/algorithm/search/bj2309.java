package Algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[9];
        int sum = 0;

        for(int i = 0; i < 9; i++){
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }

        for(int i = 0; i < 8; i++){ // 비교할 값 0번째부터 7번째까지 반복 (8번 반복)
            for(int j = i + 1; j < 9; j++){  // 비교 대상 i + 1 ~ 8까지 반복 (이미 i번째는 다 탐색했으니 i+1로 설정)
                if(sum - arr[i] - arr[j] == 100){ // 전체합에서 i 와 j의 값을 빼 100이라면 i와 j를 제외한 모두다
                    arr[i] = 0; // i, j를 초기화하고 이를 제외해서 출력
                    arr[j] = 0;
                    Arrays.sort(arr); // 오름차순 정렬
                    for(int k = 2; k < 9; k++){ // 정렬을 해주면 오름차순이기에 앞에 두개를 제외하고 출력한다
                        System.out.println(arr[k]);
                    }
                    return;
                }
            }
        }
    }
}
